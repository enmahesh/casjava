// Variables for initializer
var loanAmount, annualInterestRate, loanTermMonths, installment, monthlyRate, adjustedMonthlyPayment, monthlyPayment;

function initialize() {
    loanAmount = parseFloat(getValue("Payslip_EXT_Q_LoanAmountApplied")); // Loan amount in ksh
    annualInterestRate = parseFloat(getValue("Payslip_EXT_Q_Interestrate")); // Annual interest rate in percentage
    loanTermMonths = parseInt(getValue("Payslip_EXT_Q_LoanTerm")); // Term of the loan in months
}

function calculateMonthlyPayment() {
    initialize();
 
    monthlyRate = annualInterestRate / (12 * 100); // Calculate monthly payment
   
    monthlyPayment = loanAmount * monthlyRate / (1 - Math.pow(1 + monthlyRate, -loanTermMonths)); // Calculate monthly payment
    adjustedMonthlyPayment = (monthlyPayment * loanTermMonths) / (loanTermMonths - 2.213); // Adjust monthly payment

    // Format adjusted monthly payment to two decimal places
    adjustedMonthlyPayment = adjustedMonthlyPayment.toFixed(2);

    setValues({"Payslip_EXT_Q_Installment": adjustedMonthlyPayment}, true);  
}

function checkAbility() {
    let Margin = getValue("Payslip_EXT_Q_FinancialSafetyMargin");
    let LoanableAmount = getValue("Payslip_EXT_Q_LoanableAmount");
    let MonthlyInstallment = getValue("Payslip_EXT_Q_RequiredMonthlyInstallment");
    
    if (Margin !== undefined && LoanableAmount !== undefined && MonthlyInstallment !== undefined) {
        let difference = LoanableAmount - MonthlyInstallment;
        
        if (difference >= 0) {
            setValue("Payslip_EXT_Q_AffordabilityCheck","ABILITY OKAY");
        } else {
            setValue("Payslip_EXT_Q_AffordabilityCheck","ABILITY NOT OKAY");
        }
    }
    
}



function  ThirdOfBasicSalary(){
const BasicSalary=getValue("Payslip_EXT_Q_Basicsalary");

const NewBasicSalary= BasicSalary/3;
    
setValues({"Payslip_EXT_Q_SalaryAdjustments":NewBasicSalary}, true);

}


 
