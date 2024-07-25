

function getAddressDetails(){
	var check = getValue("AddressCheckBox");
	if (check == true){
	setValues({"POSTALADDRESS":getValue("ADDPOSTALADDRESS"),
           "PostalCode":getValue("ADDPOSTALCODE"),
           "RURALCOUNTY" : getValue("ADDCOUNTY"),
           "RURALTOWN"  : getValue("ADDTOWN"),
           "RURALNEARESTLANDMARK":getValue("ADDNEARESTLANDMARK")
          },true);
	}
	else{
		let addressFields = ["POSTALADDRESS", "PostalCode", "RURALCOUNTY", "RURALTOWN", "RURALNEARESTLANDMARK"];
          for (var a = 0; a < addressFields.length; a++) {
          clearValue(addressFields[a]);
 }
	}
}