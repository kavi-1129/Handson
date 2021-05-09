import { Employee} from './employee';
import {Department} from './department'
import { Skill } from './skill';


class EmployeeTest{
    employee:Employee;
    constructor(emp: Employee){
        this.employee=emp;
    }
    display(){
        return "Hello"+this.employee;
    }
}


const dept:Department={
    id:1,
    name:"Computer"
}

const skill:Skill={
    id:1,
    name:"coding"
}

const employee:Employee={
    id:1,
    name:"Test",
    salary:1000,
    permanent:true,
    department:dept,
    skill:skill
}

console.log(new EmployeeTest(employee));  
