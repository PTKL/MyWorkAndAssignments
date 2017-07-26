using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;
using System.Data.Odbc;

namespace IoTDemoWebService
{
    /// <summary>
    /// Summary description for Service1
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]
    public class Service1 : System.Web.Services.WebService
    {
        //String connectionString = "DRIVER={MySQL ODBC 5.1 Driver};SERVER=localhost;DATABASE=IotDatabase;USER=root;PASSWORD=root;OPTION=3;";

        [WebMethod]
        public string ArduinoData(String temp, String doorData)
        {
            try
            {
                using (OdbcConnection IotDataCon = new OdbcConnection())
                {
                    IotDataCon.ConnectionString = connectionString;
                    IotDataCon.Open();
                    // Insert or update your single record based on your need    
                    String query = "UPDATE IotDatabase.COMMAND SET TEMPERATURE='" + temp +
                                                                   "', DOOROPENED=" + doorData + " WHERE ID=1;";
                    OdbcCommand cmd = new OdbcCommand(query, IotDataCon);
                    cmd.ExecuteNonQuery();
                }
            }
            catch (OdbcException exp)
            {
                // handle your Odbc exception
                return "NOK";
            }
            return "OK";
        }
    }
}
