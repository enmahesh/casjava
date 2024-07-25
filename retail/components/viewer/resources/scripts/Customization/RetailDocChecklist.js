console.log('Inside Retail Document Checklist');

function validateAtTLS(){
    if(currentWorkstep == 'Team Leader Sales'){
        var result1=documentmandat();
        if(result1==false){
            return false;
        }
    }
} 

function documentmandat() {
    var jsonArray = [
       
        {
            "ImaraCorporate_EXT_Q_ImrcopDuly": "Loan Application Form",
            "ImaraCorporate_EXT_Q_ImrcopCRBReport": "CRB Report",
            "ImaraCorporate_EXT_Q_ImrcopPhoto": "Certified Recent Passport Size Photo",
            "ImaraCorporate_EXT_Q_ImrcopNationalID": "Certified Copy of Client National ID",
            "ImaraCorporate_EXT_Q_ImrcopKRAPI": "Certified Copy of Client KRA PIN",
            "ImaraCorporate_EXT_Q_ImrcopPaySlips": "Three Certified Current Pay Slips",
            "ImaraCorporate_EXT_Q_ImrcopEmploymentLetter": "Current Certified Employment Letter",
            "ImaraCorporate_EXT_Q_Imrcopcapitalizationform": "Installment & Charges Capitalization Consent Form",
            "ImaraCorporate_EXT_Q_ImrcopComputation": "Third Rule Computation",
            "ImaraCorporate_EXT_Q_ImrcopDeclarationForms": "Loan Application Declaration Forms"
        },
        {
            "ImaraPlus_EXT_Q_DulyFilled": "Loan Application Form",
            "ImaraPlus_EXT_Q_CRBReport": "CRB Report",
            "ImaraPlus_EXT_Q_PassportSizePhoto": "Certified Recent Passport Size Photo",
            "ImaraPlus_EXT_Q_NationalID": "Certified Copy of Client National ID",
            "ImaraPlus_EXT_Q_KRAPIN": "Certified Copy of Client KRA PIN",
            "ImaraPlus_EXT_Q_PaySlips": "Three Certified Current Pay Slips",
            "ImaraPlus_EXT_Q_EmploymentLetter": "Current Certified Employment Letter",
            "ImaraPlus_EXT_Q_capitalizationform": "Installment & Charges Capitalization Consent Form",
            "ImaraPlus_EXT_Q_Computation": "Third Rule Computation",
            "ImaraPlus_EXT_Q_DeclarationForms": "Loan Application Declaration Forms"
        },
        {
            "SalaryLoan_EXT_Q_DulyFilled": "Loan Application Form",
            "SalaryLoan_EXT_Q_CRBReport": "CRB Report",
            "SalaryLoan_EXT_Q_PassportSizePhoto": "Certified Recent Passport Size Photo",
            "SalaryLoan_EXT_Q_NationalID": "Certified Copy of Client National ID",
            "SalaryLoan_EXT_Q_KRAPIN": "Certified Copy of Client KRA PIN",
            "SalaryLoan_EXT_Q_PaySlips": "Three Certified Current Pay Slips",
            "SalaryLoan_EXT_Q_EmploymentLetter": "Current Certified Employment Letter",
            "SalaryLoan_EXT_Q_capitalizationform": "Installment & Charges Capitalization Consent Form",
            "SalaryLoan_EXT_Q_Computation": "Third Rule Computation",
            "SalaryLoan_EXT_Q_DeclarationForms": "Loan Application Declaration Forms",
            "SalaryLoan_EXT_Q_salary": "Employer Irrevocable Letter Remit Salary"
        },
        {
            "TambaImara_EXT_Q_DulyFilled": "Loan Application Form",
            "TambaImara_EXT_Q_CRBReport": "CRB Report",
            "TambaImara_EXT_Q_PassportSizePhoto": "Certified Recent Passport Size Photo",
            "TambaImara_EXT_Q_NationalID": "Certified Copy of Client National ID",
            "TambaImara_EXT_Q_KRAPIN": "Certified Copy of Client KRA PIN",
            "TambaImara_EXT_Q_PaySlips_msg": "Three Certified Current Pay Slips",
            "TambaImara_EXT_Q_EmploymentLetter": "Current Certified Employment Letter",
            "TambaImara_EXT_Q_capitalizationform": "Installment & Charges Capitalization Consent Form",
            "TambaImara_EXT_Q_Computation": "Third Rule Computation",
            "TambaImara_EXT_Q_Declaration": "Loan Application Declaration Forms",
            "TambaImara_EXT_Q_salary": "Employer Irrevocable Letter Remit Salary",
            "TambaImara_EXT_Q_Valuationreport": "Valuation Report",
            "TambaImara_EXT_Q_SaleAgreement": "Sale Agreement"
        },
        {
            "OkoaMteja_EXT_Q_DulyFilled": "Sale Agreement",
            "OkoaMteja_EXT_Q_NationalID": "Sale Agreement"
        }
    ];

    var imaraplus = {
        "ImaraPlus_EXT_Q_DulyFilled": '',
        "ImaraPlus_EXT_Q_CRBReport": '',
        "ImaraPlus_EXT_Q_PassportSizePhoto": '',
        "ImaraPlus_EXT_Q_NationalID": '',
        "ImaraPlus_EXT_Q_KRAPIN": '',
        "ImaraPlus_EXT_Q_PaySlips": '',
        "ImaraPlus_EXT_Q_EmploymentLetter": '',
        "ImaraPlus_EXT_Q_capitalizationform": '',
        "ImaraPlus_EXT_Q_Computation": '',
        "ImaraPlus_EXT_Q_DeclarationForms": ''
    };

    var imaracorporate = {
        "ImaraCorporate_EXT_Q_ImrcopDuly": '',
        "ImaraCorporate_EXT_Q_ImrcopCRBReport": '',
        "ImaraCorporate_EXT_Q_ImrcopPhoto": '',
        "ImaraCorporate_EXT_Q_ImrcopNationalID": '',
        "ImaraCorporate_EXT_Q_ImrcopKRAPI": '',
        "ImaraCorporate_EXT_Q_ImrcopPaySlips": '',
        "ImaraCorporate_EXT_Q_ImrcopEmploymentLetter": '',
        "ImaraCorporate_EXT_Q_Imrcopcapitalizationform": '',
        "ImaraCorporate_EXT_Q_ImrcopComputation": '',
        "ImaraCorporate_EXT_Q_ImrcopDeclarationForms": ''
    };

    var SalaryLoan = {
        "SalaryLoan_EXT_Q_DulyFilled": '',
        "SalaryLoan_EXT_Q_CRBReport": '',
        "SalaryLoan_EXT_Q_PassportSizePhoto": '',
        "SalaryLoan_EXT_Q_NationalID": '',
        "SalaryLoan_EXT_Q_KRAPIN": '',
        "SalaryLoan_EXT_Q_PaySlips": '',
        "SalaryLoan_EXT_Q_EmploymentLetter": '',
        "SalaryLoan_EXT_Q_capitalizationform": '',
        "SalaryLoan_EXT_Q_Computation": '',
        "SalaryLoan_EXT_Q_DeclarationForms": '',
        "SalaryLoan_EXT_Q_salary": ''
    };

    var tambaimara = {
        "TambaImara_EXT_Q_DulyFilled": '',
        "TambaImara_EXT_Q_CRBReport": '',
        "TambaImara_EXT_Q_PassportSizePhoto": '',
        "TambaImara_EXT_Q_NationalID": '',
        "TambaImara_EXT_Q_KRAPIN": '',
        "TambaImara_EXT_Q_PaySlips_msg": '',
        "TambaImara_EXT_Q_EmploymentLetter": '',
        "TambaImara_EXT_Q_capitalizationform": '',
        "TambaImara_EXT_Q_Computation": '',
        "TambaImara_EXT_Q_Declaration": '',
        "TambaImara_EXT_Q_salary": '',
        "TambaImara_EXT_Q_Valuationreport": '',
        "TambaImara_EXT_Q_SaleAgreement": ''
    };

    var okara = {
        "OkoaMteja_EXT_Q_DulyFilled": '',
        "OkoaMteja_EXT_Q_NationalID": ''
    };

    var keysArray = [];
    var id = null;

    //dropdown value for checklists document visibility
    var Checklistsdisp = getValue("FACILITYPRODUCT");
console.log(Checklistsdisp);
    switch (Checklistsdisp) {
        case "1":
            id = imaracorporate;
            break;
        case "2":
            id = imaraplus;
            break;
        case "3":
            id = SalaryLoan;
            break;
        case "4":
            id = tambaimara;
            break;
        case "5":
            id = okara;
            break;
        default:
            id = {}; // Set to empty object if no match
    }     console.log(id);

    Object.keys(id).forEach(function (key) {
        id[key] = getValue(key);
        if (id[key] == 'Yes') {
            keysArray.push(key);
        }
    });

    // Select the relevant JSON object based on the dropdown number 12345
    var jsonObject = jsonArray[Checklistsdisp - 1];

    // valuesArray is like arr from the frontend Create a new array that contains the values corresponding to the keys in keysArray
    var valuesArray = keysArray.map(key => jsonObject[key]);
    console.log(valuesArray);

    var result = xmldoc();
    console.log(result);

    var doclist = executeServerEvent("MandatDocumentChecker", "document", result, true);
    console.log(doclist);

    const delimiter = "##";
    const array1 = doclist.split(delimiter);
    console.log(array1);

    const allPresent = valuesArray.every(element => array1.includes(element));
    console.log("this is allpresent" + allPresent);

    const missingElements = valuesArray.filter(element => !array1.includes(element));
    console.log("The missing elements are" + missingElements);
    var missedelements="You have missed the following documents:" + missingElements.join(", ");
    if (!allPresent) {
        showMessage("textbox1",missedelements,"error");
        return false;
    }
}

function xmldoc() {
    var objData = ["DLIST"];
    var retXml = window.parent.getInterfaceData(objData, "");

    return retXml;
}