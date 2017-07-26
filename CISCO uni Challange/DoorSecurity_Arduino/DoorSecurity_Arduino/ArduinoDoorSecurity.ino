
#include <SPI.h>
#include <Ethernet.h>
#include <math.h>
byte mac[] = { 0xDE, 0xAC, 0xBA, 0xEA, 0xFE, 0xED };
char server[] = "api.thingspeak.com";    // name address for Thingspeak.com (using DNS)
IPAddress ip(192,168,1,177);
long lastConnectionTime = 0;
const int updateInterval = 30; 
boolean lastConnected=false;
const int pingPin = 8;
const int trigPin = 7; 

double Thermister(int RawADC) {  
 double Temp;
 Temp = log(((10240000/RawADC) - 10000));
 Temp = 1 / (0.001129148 + (0.000234125 + (0.0000000876741 * Temp * Temp ))* Temp );
 Temp = Temp - 273.15;              // Convert Kelvin to Celsius
 return Temp;
}

long microsecondsToInches(long microseconds)
{
  // According to Parallax's datasheet for the PING))), there are
  // 73.746 microseconds per inch (i.e. sound travels at 1130 feet per
  // second).  This gives the distance travelled by the ping, outbound
  // and return, so we divide by 2 to get the distance of the obstacle.
  // See: http://www.parallax.com/dl/docs/prod/acc/28015-PING-v1.3.pdf
  return microseconds / 74 / 2;
}

long microsecondsToCentimeters(long microseconds)
{
  // The speed of sound is 340 m/s or 29 microseconds per centimeter.
  // The ping travels out and back, so to find the distance of the
  // object we take half of the distance travelled.
  return microseconds / 29 / 2;
}

void setup() {

  if (Ethernet.begin(mac) == 0) {
    Ethernet.begin(mac, ip);
  }
   delay(1000);
   pinMode(5, OUTPUT);
   digitalWrite(5,HIGH);
   pinMode(trigPin, OUTPUT);
   pinMode(pingPin, INPUT);
   pinMode(6,OUTPUT);
   Serial.begin(9600);
   delay(1000);
}

int st=0;
void loop()
{
  double c=Thermister(analogRead(A0));
  static char outstr[15];
  dtostrf(c,6,2,outstr);
  String celcius(outstr);
  if(((millis() - lastConnectionTime) * 1000) > updateInterval)
  {
    updateData("data="+ celcius+"&status="+String(st,DEC));
  }

  long duration, inches, cm;

  digitalWrite(trigPin, LOW);
  delayMicroseconds(2);
  digitalWrite(trigPin, HIGH);
  delayMicroseconds(5);
  digitalWrite(trigPin, LOW);
  duration = pulseIn(pingPin, HIGH);
  inches = microsecondsToInches(duration);
  cm = microsecondsToCentimeters(duration);
  if(cm>25)
  {
    st=1;
    digitalWrite(6,HIGH);
        updateData("data="+ celcius+"&status="+String(st,DEC));
  }
  else
  {
    st=0;
    digitalWrite(6,LOW);
  }
  Serial.print(cm);
  Serial.print("cm");
  Serial.println();
  delay(1000);
}

void updateData(String data)
{
  EthernetClient client;
  if (client.connect(server, 80)) {
    String content=data;
    // Make a HTTP request:
    client.print("POST /apps/thinghttp/send_request HTTP/1.1\n");
    client.print("Host: api.thingspeak.com\n");
    client.print("Connection: close\n");
    client.print("X-THINGSPEAKAPIKEY: EJ0CYPZO9LB66YPX\n");
    client.print("Content-Type: application/x-www-form-urlencoded\n");
    client.print("Content-Length: ");
    client.print(data.length());
    client.print("\n\n");
    client.print(data);  
    lastConnectionTime = millis(); 
      
      if (client.available()) {
        char c = client.read();
      }
      client.stop();
  } 
  else {
    // ok you didn't get a connection to the server: do something to handle this
  }
}

