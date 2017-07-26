using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using Google.GData.Client;
using Google.GData.Spreadsheets;
using System.Threading;

namespace IoTDeviceClient
{
    public partial class IoTDeviceClient : Form
    {
        public class DeviceData
        {
            public double dTemperature;
            public double dThresholdMax;
            public double dThresholdMin;
            public int nAlarmEnabled;
            public int nDoorOpened;
            public int nHeaterSwitch;
            public int nCoolerSwitch;
            public DeviceData(double temp, double tmax, double tmin, int dalarm, int dopen, int hswitch, int cswitch)
            {
                dTemperature = temp;
                dThresholdMax = tmax;
                dThresholdMin = tmin;
                nAlarmEnabled = dalarm;
                nDoorOpened = dopen;
                nHeaterSwitch = hswitch;
                nCoolerSwitch = cswitch;
            }
        }

        DeviceData mDeviceData;
        
        OAuth2Parameters parameters;
        GOAuth2RequestFactory requestFactory;
        SpreadsheetsService myService;


        public IoTDeviceClient()
        {
            InitializeComponent();
            mDeviceData = new DeviceData(0, 0, 0, 0, 0, 0, 0);
            parameters = new OAuth2Parameters();
        }

        public bool ConnectToGoogle(bool link = true)
        {
            try
            {
                if (link)
                {
                    string CLIENT_ID = "your-client-id-here";
                    string CLIENT_SECRET = "your-client-secret-here";
                    string SCOPE = "https://spreadsheets.google.com/feeds https://docs.google.com/feeds";
                    string REDIRECT_URI = "your-redirect-uri";

                    // Set your OAuth 2.0 Client Id (which you can register at
                    // https://code.google.com/apis/console).
                    parameters.ClientId = CLIENT_ID;

                    // Set your OAuth 2.0 Client Secret, which can be obtained at
                    // https://code.google.com/apis/console.
                    parameters.ClientSecret = CLIENT_SECRET;

                    // Set your Redirect URI, which can be registered at
                    // https://code.google.com/apis/console.
                    parameters.RedirectUri = REDIRECT_URI;

                    parameters.Scope = SCOPE;


                    string authorizationUrl = OAuthUtil.CreateOAuth2AuthorizationUrl(parameters);

                    Clipboard.SetText(authorizationUrl);
                    MessageBox.Show("Authorization URL copied to your Computer Clipboard! Paste & authorize through your Internet Browser.");
                }
                else
                {
                    parameters.AccessCode = textBox1.Text;
                    OAuthUtil.GetAccessToken(parameters);
                    string accessToken = parameters.AccessToken;

                    requestFactory = new GOAuth2RequestFactory(null, "MySpreadsheetIntegration-v43234", parameters);

                    myService = new SpreadsheetsService("MySpreadsheetIntegration-v43234");
                    myService.RequestFactory = requestFactory;
                }

                return true;
            }
            catch (Exception exp)
            {

                return false;
            }
        }

        private void doJob(bool bRead = false)
        {
            RefreshView(bRead);
            Thread thread = new Thread(() => RefreshData(mDeviceData, bRead));
            thread.Start();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            if (ConnectToGoogle(false))
            {
                button2.Enabled = false;
                doJob(true);
                RefreshTimer.Start();
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (ConnectToGoogle())
            {
                button2.Enabled = true;
                button1.Enabled = false;
            }
            
        }

        private void RefreshTimer_Tick(object sender, EventArgs e)
        {
            try
            {
                doJob();
            }
            catch (Exception exp)
            {
                MessageBox.Show(exp.Message);
            }
        }

        public void RefreshView(bool bRead=false)
        {
            if (bRead)
            {
                checkBox1.Checked = mDeviceData.nHeaterSwitch == 1 ? true : false;
                checkBox2.Checked = mDeviceData.nCoolerSwitch == 1 ? true : false;
                checkBox3.Checked = mDeviceData.nAlarmEnabled == 1 ? true : false;
            }
            label2.Text = "Temperature : " +mDeviceData.dTemperature.ToString() + " Degree Celsius";
            if (mDeviceData.nAlarmEnabled == 0)
                alarmBox.Image = Image.FromStream(System.Reflection.Assembly.GetExecutingAssembly().GetManifestResourceStream("IoTDeviceClient.Images.lock_disabled.png"));
            else if (mDeviceData.nDoorOpened == 0)
                alarmBox.Image = Image.FromStream(System.Reflection.Assembly.GetExecutingAssembly().GetManifestResourceStream("IoTDeviceClient.Images.lock.png"));
            else if (mDeviceData.nDoorOpened == 1)
                alarmBox.Image = Image.FromStream(System.Reflection.Assembly.GetExecutingAssembly().GetManifestResourceStream("IoTDeviceClient.Images.unlock.png"));
            alarmBox.Refresh();
        }

        public void RefreshData(DeviceData deviceData, bool bRead)
        {
            try
            {
                SpreadsheetQuery query = new SpreadsheetQuery();
                SpreadsheetFeed feed = myService.Query(query);
                foreach (SpreadsheetEntry entry in feed.Entries)
                {
                    if (entry.Title.Text.Trim() == "TestData")
                    {
                        AtomLink link = entry.Links.FindService(GDataSpreadsheetsNameTable.WorksheetRel, null);

                        WorksheetQuery wsquery = new WorksheetQuery(link.HRef.ToString());
                        WorksheetFeed wsfeed = myService.Query(wsquery);

                        foreach (WorksheetEntry worksheet in wsfeed.Entries)
                        {
                            if (worksheet.Title.Text == "COMMAND")
                            {
                                AtomLink listFeedLink = worksheet.Links.FindService(GDataSpreadsheetsNameTable.ListRel, null);

                                // Fetch the list feed of the worksheet.
                                ListQuery listQuery = new ListQuery(listFeedLink.HRef.ToString());
                                ListFeed listFeed = myService.Query(listQuery); 

                                listFeed = myService.Query(listQuery); ;
                                foreach (ListEntry.Custom element in ((ListEntry)listFeed.Entries[0]).Elements)
                                {
                                    if (element.LocalName == "temperature")
                                        mDeviceData.dTemperature = Convert.ToDouble(element.Value.ToString());
                                    else if (element.LocalName == "thresholdmax")
                                        mDeviceData.dThresholdMax = Convert.ToDouble(element.Value.ToString());
                                    else if (element.LocalName == "thresholdmin")
                                        mDeviceData.dThresholdMin = Convert.ToDouble(element.Value.ToString());
                                    else if (element.LocalName == "dooralarm" && !bRead)
                                        element.Value = deviceData.nAlarmEnabled.ToString();
                                    else if (element.LocalName == "dooralarm" && bRead)
                                        deviceData.nAlarmEnabled = Convert.ToInt32(element.Value.ToString());
                                    else if (element.LocalName == "dooropened")
                                        mDeviceData.nDoorOpened = Convert.ToInt32(element.Value.ToString());
                                    else if (element.LocalName == "heaterswitch" && !bRead)
                                        element.Value = deviceData.nHeaterSwitch.ToString();
                                    else if (element.LocalName == "heaterswitch")
                                        deviceData.nHeaterSwitch = Convert.ToInt32(element.Value.ToString());
                                    else if (element.LocalName == "coolerswitch" && !bRead)
                                        element.Value = deviceData.nCoolerSwitch.ToString();
                                    else if (element.LocalName == "coolerswitch")
                                        deviceData.nCoolerSwitch = Convert.ToInt32(element.Value.ToString());
                                }
                                ((ListEntry)listFeed.Entries[0]).Update();
                                break;
                            }
                        }
                        break;
                    }
                }
            }
            catch (Exception exp)
            {
                MessageBox.Show(exp.Message);
            }
        }

        private void checkBox1_CheckedChanged(object sender, EventArgs e)
        {
            mDeviceData.nHeaterSwitch = checkBox1.Checked ? 1 : 0;
        }

        private void checkBox2_CheckedChanged(object sender, EventArgs e)
        {
            mDeviceData.nCoolerSwitch = checkBox2.Checked ? 1 : 0;
        }

        private void checkBox3_CheckedChanged(object sender, EventArgs e)
        {
            mDeviceData.nAlarmEnabled = checkBox3.Checked ? 1 : 0;
        }

        private void IoTDeviceClient_Load(object sender, EventArgs e)
        {

        }
    }
}
