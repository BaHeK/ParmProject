package com.example.newnew;

import java.io.IOException;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

public class SoapRequest {
	

	public SoapObject sendRequest(SoapObject request,String urlRequest) {
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER10);
		envelope.setOutputSoapObject(request);

		HttpTransportSE transport = new HttpTransportSE(urlRequest);
		transport
				.setXmlVersionTag("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		try {
			transport.call(SoapConstants.SOAP_ACTION, envelope);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SoapObject resa = (SoapObject) envelope.bodyIn;
		return resa;
	}

}
