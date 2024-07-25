
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
		
	}
	if(currentApprovalDecision == DecisionObj.Query){
		setStyle("NextWorkdesk","disable","false");
		setStyle("NextWorkdesk","mandatory","true");
		
	}
	
	if(currentApprovalDecision == DecisionObj.Reject){
		setStyle("NextWorkdesk","disable","false");
		clearComboOptions("NextWorkdesk");
		addItemInCombo("NextWorkdesk", "END");
		setStyle("NextWorkdesk","mandatory","true");
		setStyle("declineReason","visible","true");
		setStyle("declineReason","mandatory","true");
		

	}
	else{
		setStyle("NextWorkdesk","disable","false");
		setStyle("declineReason","visible","false");

	}
	if(currentApprovalDecision == DecisionObj.Approved){
		setStyle("NextWorkdesk","disable","true");
		setStyle("NextWorkdesk","mandatory","false");
		
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


function getNextworkDesk() {
  var currentWorkstep = getWorkItemData("activityname");
  var decision = getValue("ApprovalDecision");

  const preApprovalSteps = [
    "Team Leader Sales", "OM_HR", "Branch Manager", "DRU", "DRU Manager",
    "HOD", "Credit Analyst", "Credit Manager", "Senior Credit Manager",
    "Head Credit MD", "CEO"
  ];

  const postApprovalSteps = [
    "LOO Officer", "QA Officer", "RO Schemes", "MIS Officer", "Credit Admin Manager"
  ];

  

  const endWorkstep = "END";

  clearComboOptions('NextWorkdesk');

  if (decision === "Declined") {
    addItemInCombo("NextWorkdesk", endWorkstep);
  } else {
    let stepsToAdd = [];

    if (postApprovalSteps.includes(currentWorkstep)) {
      stepsToAdd = postApprovalSteps;
    } else if (preApprovalSteps.includes(currentWorkstep)) {
      stepsToAdd = preApprovalSteps;
    }

    // Add steps to combo excluding the current work step
    for (const step of stepsToAdd) {
      if (step !== currentWorkstep) {
        addItemInCombo("NextWorkdesk", step);
      }
    }
  }
}


