import { Component, OnInit } from '@angular/core';
import { BillsService } from 'src/app/services/bills.service';

@Component({
  selector: 'app-view-bill',
  templateUrl: './view-bill.component.html',
  styleUrls: ['./view-bill.component.css']
})
export class ViewBillComponent implements OnInit {

  isVisible: boolean = false; 
  memberId:string = "";

  policyId:string = "";
  dueAmount:any = ""; 
  dueDate:string = ""; 
lastPaidDate:string = "";
lateCharge: any = "";


  constructor(private billService:BillsService) { }

  ngOnInit(): void {
  }

  getBills(){

    this.billService.viewBills(this.memberId).subscribe(
          
      (response:any) =>{
         this.isVisible = true;
           console.log(response.memberId);
           console.log(response.policyId);
           console.log(response);

          //  this.policyId = "Policy ID is :" + response.policyId;
          //  this.dueAmount ="Due Amount is Rs. " + response.dueAmount;
          //  this.dueDate = "Due Date is: " + response.dueDate;
          //  this.lastPaidDate = "Last Paid Date is :" +response.lastPaidDate;
          //  this.lateCharge = "Late Charge is Rs. " + response.lateCharge;
           this.policyId =  response.policyId;
           this.dueAmount ="Rs." + response.dueAmount;
           this.dueDate = response.dueDate;
           this.lastPaidDate = response.lastPaidDate;
           this.lateCharge = "Rs." + response.lateCharge;
          
          },
      error =>{
           console.log(error);
      }
    );

  }

}
