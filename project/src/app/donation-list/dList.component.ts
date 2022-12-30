import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-donation-list',
  templateUrl: './dList.component.html',
  styleUrls: ['./dList.component.css']
})
export class DonationListComponent implements OnInit {

  constructor(private http:HttpClient, private router: Router, private route: ActivatedRoute) { }

  name:any 
  address: any
  region: any
  city: any
  phone: any
  timeFrom: any
  timeTo: any

  response: any

  res1: any;  res2: any;  res3: any
  res: any

  authNum: any = 1

  sameRegionAuth: any
  sameCityAuth: any
  otherCitiesAuth: any

  ngOnInit(): void {
    this.getSameRegionAuth()
    this.getSameCityAuth()
    this.getOtherCitiesAuth()    
  }

   showAuth(){
    const newContainer = document.createElement("div");
    newContainer.className = "containerDon";
    newContainer.innerHTML += '<div>Authority number' + this.authNum++ + '</div>'
      + '<div class="proContent" style="max-width: 700px;">' 
        + '<div class="scroll-container">' 
          + '<div class="card p-3 border border-danger m-3">' 
            + '<div class="row">'

              + '<p class="col-12" id="hos-name">'+ this.name +'</p>' 
              + '<p class="col-6" id="hos-addr">' + this.address + '</p>'  
              +'<br>'
              +'<p class="col-12" id="hos-numb">' + this.phone + '</p>'
              +'<p class="col-12" for="">Donation time:</p>'
              +'<p class="col-6">From:' + this.timeFrom + '</p>'
              +'<P class="col-4">To:' + this.timeTo + '</P>'

            + '</div>' 
          + '</div>' 
        + '</div>'
      +'</div>'
      document.body.appendChild(newContainer);
    }

   getSameRegionAuth(){
    this.http.get('http://localhost:6060/savior/sameRegion',{
      responseType:'text',
      observe:'response'
    }).subscribe(response=>{
      this.sameRegionAuth = response.body
      console.log("same region from back: " + this.sameRegionAuth)
      if(this.sameRegionAuth.length == 0){
        console.log("no in same region")
      }

      this.res1 = this.sameRegionAuth.split(",");
      
      console.log(this.res1)
      for(var i = 0; i < this.res1.length-1; i+=5){
        this.name = this.res1[i]
        this.address = this.res1[i+1]
        this.phone = this.res1[i+2]
        this.timeFrom = this.res1[i+3]
        this.timeTo = this.res1[i+4]

        //html
        console.log("in for loop now!")
        this.showAuth()
      }
    })
  }

  getSameCityAuth(){
    this.http.get('http://localhost:6060/savior/sameCity',{
      responseType:'text',
      observe:'response'
    }).subscribe(response=>{
      this.sameCityAuth = response.body
      console.log("same city from back: " + this.sameCityAuth)
      if(this.sameCityAuth.length == 0){
        console.log("no in same city")
      }

      this.res2 = this.sameCityAuth.split(",");
      
      console.log(this.res2)
      for(var i = 0; i < this.res2.length-1; i+=6){
        this.name = this.res2[i]
        this.address = this.res2[i+1]
        this.region = this.res2[i+2]
        this.phone = this.res2[i+3]
        this.timeFrom = this.res2[i+4]
        this.timeTo = this.res2[i+5]

        //html
        this.showAuth()
      }
    })
  }

  getOtherCitiesAuth(){
    this.http.get('http://localhost:6060/savior/otherCities',{
      responseType:'text',
      observe:'response'
    }).subscribe(response=>{
      this.otherCitiesAuth = response.body
      console.log("other cities from back: " + this.otherCitiesAuth)
      if(this.otherCitiesAuth.length == 0){
        console.log("no in other cities")
      }

      this.res3 = this.otherCitiesAuth.split(",");
      
      console.log(this.res3)
      for(var i = 0; i < this.res3.length-1; i+=7){
        this.name = this.res3[i]
        this.address = this.res3[i+1]
        this.region = this.res3[i+2]
        this.city = this.res3[i+3]
        this.phone = this.res3[i+4]
        this.timeFrom = this.res3[i+5]
        this.timeTo = this.res3[i+6]

        //html
        this.showAuth()
      }
    })
  }

  choose(name: any, address: any){
    console.log("choose calling")
    const authNumber = (<HTMLInputElement>document.getElementById('aNum'))
    this.authNum = authNumber.value
    console.log("user chose authority number: " + this.authNum)
    this.http.get('http://localhost:6060/savior/chooseAuth',{ 
    responseType:'text',
    params:{
      name: name,
      address: address
    },
    observe:'response'
    }).subscribe(response=>{
      this.response = response.body
      console.log(this.response)
      this.router.navigateByUrl('/donationTicket') //routing to donation ticket
    })
  }

  confirm(){
    console.log("confirm calling")
    this.res = this.res1.concat(this.res2, this.res3)
    console.log("the concatenated res: " + this.res)
    this.choose(this.res[(this.authNum-1)*7], this.res[( (this.authNum-1)*7 ) + 1])
  }

}