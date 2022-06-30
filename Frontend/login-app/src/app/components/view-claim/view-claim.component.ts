import { Component, OnInit } from '@angular/core';
import { BillsService } from 'src/app/services/bills.service';

@Component({
  selector: 'app-view-claim',
  templateUrl: './view-claim.component.html',
  styleUrls: ['./view-claim.component.css']
})
export class ViewClaimComponent implements OnInit {
  isVisible: boolean = false; 
  public claimId:string = "";
  public claimStatus:string = "";
  public claimDesc:string = "";
  public fetchedId:string = "";

  constructor(private billService:BillsService) { }

  ngOnInit(): void {
  }
  getClaimStatus(){
    this.billService.getClaims(this.claimId).subscribe(

      (response:any) =>{
           this.isVisible = true;
        console.log(response);
        // this.claimStatus = "Claim Status : " + response.claimStatus;
        // this.claimDesc = "Claim Analysis: " + response.claimDescription;
        // this.fetchedId = "Claim ID is :" + response.claimId;
           this.fetchedId = response.claimId;
           this.claimStatus =  response.claimStatus;
           this.claimDesc = response.claimDescription;
      },

      error =>{

      }


    )
  }

}
