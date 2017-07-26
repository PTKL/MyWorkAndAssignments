<?php

require "twilio/Services/Twilio.php";
     
function sqlconnect()
{
    $dbhost="localhost";           //database host
    $dbuser="root";            //database username
    $dbpassword="xxxxxx";        //database password      
    $dbname="xxxxx";            //database name
    $db = mysql_connect($dbhost,$dbuser,$dbpassword) or die("Couldn't connect to the database.");
    mysql_select_db($dbname) or die("Couldn't select the database");
    return($db);
}
     
     
    



 
 
function sendsms($msg) {
    $AccountSid = "xxxxx";  //twilio settings
    $AuthToken = "xxxx";   //twilio settings
    $client = new Services_Twilio($AccountSid, $AuthToken);
//    $sms = $client->account->sms_messages->create("xxxx", "+xxxx", $msg);  //twilio settings
    $sms = $client->account->sms_messages->create("6xxxx", "+xxxx", $msg);   //twilio settings
    echo"\n\nSending SMS\n\n";
}  






$queue = array();

//////// setup our named pipe ////////

$pipefile = '/tmp/aironetpipe';
if(file_exists($pipefile))
    if(!unlink($pipefile)) 
        die('unable to remove stale file');

umask(0);
if(!posix_mkfifo($pipefile,0666))
    die('unable to create named pipe');

$pipe = fopen($pipefile,'r+');
if(!$pipe) die('unable to open the named pipe');
stream_set_blocking($pipe,false);

//////// process the queue ////////
while(1) {

    while($input = trim(fgets($pipe))) {
        stream_set_blocking($pipe,false);
        $queue[] = $input;
    }

    $job = current($queue);
    $jobkey = key($queue);
    if($job) {
        echo '\n\nprocessing job ', $job, PHP_EOL;
        
        //process($job);
        
        
        if (strstr($job, "-ASSOC")) {  //check for association
      			$db = sqlconnect();		
        		$match = "/(?<=Station)(.*)(?=Associated)/";
        		preg_match($match, $job, $regexresult);
				$mac = trim($regexresult[0]);
				if ($mac != ""){  //get rid of reassociations
					echo"\nAssociation found - checking database…  mac = $mac\n";
					
				

					$result = mysql_query("SELECT * FROM mactable WHERE `mac` = '$mac'") or die("Error: " . mysql_error());
					$num_rows = mysql_num_rows($result);
					
					if ($num_rows == "0") {
						$result = mysql_query("INSERT INTO mactable VALUES ('$mac', now(), '', '')") or die("Error: " . mysql_error());
						sendsms("New device detected on home network.  MAC address $mac");
					}  else  {

						while ($row = mysql_fetch_array($result, MYSQL_NUM)) {
							if ($row[3] != "N"){
								echo"Device detected on home network $mac ($row[2])\n\n";
								if ($row[2] == "") {  
									sendsms("Device detected on home network: $mac");
								} else {
									sendsms("Device detected on home network: $row[2]");
								}	
						
							}
							
						$result = mysql_query("UPDATE mactable SET lastseen = now() WHERE mac = '$mac'") or die("Error: " . mysql_error());
							
						}
  
					}
				}
				mysql_close($db);
        }
        
        
        
        next($queue);
        unset($job,$queue[$jobkey]);        
        
        
        
    } else {
        echo 'no jobs to do - waiting...', PHP_EOL;
        stream_set_blocking($pipe,true);
    }

}

?>
