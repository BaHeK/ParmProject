package com.example.newnew;

public class SoapConstants {
	private static SoapConstants instance;
	private String URL;
	private String URL2;
//	public static final String URL = "http://172.22.5.14:8899/BorderWebService-PArmProject-context-root/PArmControlSoapHttpPort";
//	public static final String URL2 = "http://172.22.5.14:8899/BorderWebService-PArmProject-context-root/PArmCommonSoapHttpPort";
	public static final String SOAP_ACTION = "";
	public static final String NAMESPACE = "http://borderbel/PArmControl.wsdl/types/";
	public static final String NAMESPACE2 = "http://borderbel/PArmCommon.wsdl";

	
	public static SoapConstants getInstance() {
		if (instance == null) {
			instance = new SoapConstants();
		}
		return instance;
	}
	public static void setInstance(SoapConstants instance) {
		SoapConstants.instance = instance;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = "http://"+"172.22.5.18"+":8899/BorderWebService-PArmProject-context-root/PArmControlSoapHttpPort";
	}
	public String getURL2() {
		return URL2;
	}
	public void setURL2(String uRL2) {
		URL2 = "http://"+"172.22.5.18"+":8899/BorderWebService-PArmProject-context-root/PArmCommonSoapHttpPort";
	}
	//172.22.5.18

}
