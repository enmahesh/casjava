console.log('Inside ApprovalLog');

const DecisionObj = {
   Approved: "Approved",
   Reject: "Declined",
   Query: "Defferal",
   QueryResponse: "Defferal Response"
 };
 
 const logObj = {
   "decision":"Decision",
   "dateandtime":"Date & Time",
   "username":"User Name",
   "fromworkstep":"From Workdesk",
   "nextworkstep":"Next Workdesk",
   "remarks":"Approval Remarks"
}

// Variables for initializer
var currentWorkStepName, currentApprovalDecision, rowcount, lastWorkStepNameInTable, lastcurrentApprovalDecisionInTable, currentDateTime, nextWorkdesk, currentUserName;		

// Initializer function
function initializer(){
	
	currentDateTime = getValue('CurrentDateTime');
	currentUserName = getWorkItemData("username");
	
	currentWorkStepName = getValue('ActivityName');
	currentApprovalDecision = getValue('ApprovalDecision');

	rowcount = getGridRowCount("ApprovalLog_Q");
	lastWorkStepNameInTable = getValueFromTableCell('ApprovalLog_Q',rowcount-1 ,3);
	lastcurrentApprovalDecisionInTable = getValueFromTableCell('ApprovalLog_Q',rowcount-1 ,0);

	nextWorkdesk = getValue('NextWorkdesk');
}

function onFormLoadApprovalLog(){
	
	initializer();
	if(currentWorkStepName != 'Initiate'){
		onLoadApprovalDecisionData();
	}
	
}

function onSaveApprovalLog(){
	addRowToApprovalLog();
}

// Approval Chain decision based on previous Workdesk Decision
function onLoadApprovalDecisionData(){
	
	initializer();
	if( currentWorkStepName != lastWorkStepNameInTable){
		
		if(lastcurrentApprovalDecisionInTable == DecisionObj.Query){
			clearComboOptions("currentApprovalDecision");
			addItemInCombo("currentApprovalDecision", DecisionObj.QueryResponse, DecisionObj.QueryResponse);
		}
		else{
			clearComboOptions("currentApprovalDecision")
			addItemInCombo("currentApprovalDecision", DecisionObj.Approved, DecisionObj.Approved);
			addItemInCombo("currentApprovalDecision", DecisionObj.Query, DecisionObj.Query);
			addItemInCombo("currentApprovalDecision", DecisionObj.Reject, DecisionObj.Reject);	
		}
	
		//clearComboOptions("NextWorkdesk");		// Cleared from the Process Itself
		setValues({"ApprovalDecision":""},true);
		setValues({"ApprovalRemarks":""},true);
	}
}

//When decision is QueryResponse
function handleQueryResponse(){
	
	initializer();
	
	
	if(currentApprovalDecision == DecisionObj.QueryResponse){
		setValues({"NextWorkdesk":lastWorkStepNameInTable},true);
		setStyle("NextWorkdesk","disable","true");
		
	}else{
		setStyle("NextWorkdesk","disable","false");
	}
}

// Approval Chain Logs Data to save on Grid....
function addRowToApprovalLog() {

	initializer();
	
	if (currentWorkStepName == lastWorkStepNameInTable){
		deleteRowsFromGrid('ApprovalLog_Q',[rowcount-1])
	} 
	
	var remarks = getValue('ApprovalRemarks');
	
	var jsonData = `[{"${logObj.decision}":"${currentApprovalDecision}","${logObj.dateandtime}":"${currentDateTime}", "${logObj.username}": "${currentUserName}","${logObj.fromworkstep}":"${currentWorkStepName}","${logObj.nextworkstep}":"${nextWorkdesk}","${logObj.remarks}":"${remarks}"}]`;
	
	addDataToGrid("ApprovalLog_Q",JSON.parse(jsonData));

	saveWorkItem();
}




