console.log('Inside FacilityDetails');

function showHideChecklistByFacility(){

	//Hiding all frames
	var frameSections = ['Product1','Product2','Product3','Product4','Product5'];
	for(let i = 0; i < frameSections.length; i++)
	{
		setStyle(frameSections[i],"visible","false"); 
	}
	
	//Showing specific frame
	let facilityProduct = getValue("FACILITYPRODUCT");
	setStyle("Product"+facilityProduct,"visible","true");
}

function convertAmtNoToWord(){
	var amt = getValue('Amount');
	var loanAmtWord = convertNumberToWords(parseFloat(amt));
	setValues({AmountInWord:loanAmtWord},true)
}