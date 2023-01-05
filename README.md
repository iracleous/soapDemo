http://localhost:8080/soapDemo/AccountWS?wsdl


http://localhost:8080/soapDemo/AccountWS

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" 
xmlns:acc="http://account.soapdemo.codehub.gr/">
   <soapenv:Header/>
   <soapenv:Body>
      <acc:newAccount>
         <!--Optional:-->
         <arg0>?</arg0>
      </acc:newAccount>
   </soapenv:Body>
</soapenv:Envelope>