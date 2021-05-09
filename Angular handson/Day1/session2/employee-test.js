"use strict";
exports.__esModule = true;
var EmployeeTest = /** @class */ (function () {
    function EmployeeTest(emp) {
        this.employee = emp;
    }
    EmployeeTest.prototype.display = function () {
        return "Hello" + this.employee;
    };
    return EmployeeTest;
}());
var dept = {
    id: 1,
    name: "Computer"
};
var skill = {
    id: 1,
    name: "coding"
};
var employee = {
    id: 1,
    name: "Test",
    salary: 1000,
    permanent: true,
    department: dept,
    skill: skill
};
console.log(new EmployeeTest(employee));
