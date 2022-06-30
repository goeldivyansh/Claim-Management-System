import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { BillsService } from 'src/app/services/bills.service';

@Component({
  selector: 'app-submit-claim',
  templateUrl: './submit-claim.component.html',
  styleUrls: ['./submit-claim.component.css']
})
export class SubmitClaimComponent implements OnInit {

  claimDetails = {
    claimId:"",
    status:''  ,
    description: '',
   remarks :'',
  claimAmount : '',
  hospitalId :'',
  benefitId: '',
   policyId:'',
  memberId:""

}
public message:string = "";


  constructor(private billService:BillsService, private snackbar:MatSnackBar) { }

  ngOnInit(): void {
  }

  // submitClaim(){
    
  //   this.billService.setClaim(this.claimDetails).subscribe(
  //     (response:any) =>{
  //            console.log(response);
  //            if(response != null){
  //             this.message = "Your Claim Has Been Successfully Submitted!"
  //            }
  //     },
  //     error =>{
  //       console.log(error);
  //       this.message = "Claim has not been Submitted, Please Try Again";
  //     }
  //   )
  // }

  submitClaim(){
    
    this.billService.setClaim(this.claimDetails).subscribe(
      (response:any) =>{
             console.log(response);
             if(response != null){
              //this.message = "Your Claim Has Been Successfully Submitted!"
              this.snackbar.open('Your Claim ID-' + response.claimId + ' has Been Submitted!','OK',{
                duration:5000
              });
             

             }
      },
      error =>{
        console.log(error);
        this.snackbar.open('Your Claim has Not Been Submitted. Please Try Again!','OK',{
          duration:5000
        });//this.message = "Claim has not been Submitted, Please Try Again";

      }
    )
  }

 

}
