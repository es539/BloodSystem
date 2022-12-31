import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-acception-list',
  templateUrl: './aList.component.html',
  styleUrls: ['./aList.component.css']
})
export class AcceptionListComponent implements OnInit {

  constructor(private http:HttpClient, private router: Router, private route: ActivatedRoute) { }

  name: any
  address: any
  phone: any
  city: any
  region: any
  
  timeFrom: any
  timeTo: any
  
  response: any
  result1:any
  result2:any
  result3: any
  result: any

  authNum: any =1
  choosenNumber: any


  SameCityRegion: any
  SameCityDiffRegion: any
  DiffCityRegion: any

  ngOnInit(): void {

    this.getSameCityRegion()
    this.getSameCityDiffRegion()
    this.getDiffCityRegion()
    
  }

  

  showAuthority()
  {
    const newContainer = document.createElement("div");
    newContainer.className = "containerDon";
    newContainer.innerHTML += '<div>Authority number #' + this.authNum++ + '</div>'
      + '<div class="proContent" style="max-width: 700px;">' 
        + '<div class="scroll-container">' 
          + '<div class="card p-3 border border-danger m-3">' 
            + '<div class="row">'

              + '<p class="col-12" id="hos-name"><span class="fw-bold">Name: </span>'+this.name+'</p>' 
              + '<p class="col-12" id="hos-addr"><span class="fw-bold">Address: </span>'+this.address+'</p>'  
              + '<p class="col-4" id="hos-region"><span class="fw-bold">Region: </span>' + this.region + '</p>' 
              + '<p class="col-4" id="hos-city"><span class="fw-bold">City: </span>' + this.city + '</p>' 
              +'<br>'
              +'<p class="col-12" id="hos-numb"><span class="fw-bold">Phone: </span>'+this.phone+'</p>'
              +'<p class="col-4 fw-bold" for="">Acception time:</p>'
              +'<p class="col-4"><span class="fw-bold">From: </span>'+this.timeFrom+'</p>'
              +'<p class="col-4"><span class="fw-bold">To: </span>'+this.timeTo+'</p>'

            + '</div>' 
          + '</div>' 
        + '</div>'
      +'</div>'
      document.body.appendChild(newContainer);
  }

  getSameCityRegion(  )
  {
    this.http.get('http://localhost:6060/savior/sameRegionCity',{
      responseType:'text',
      observe:'response'
    }).subscribe(response=>{
      this.SameCityRegion = response.body
      console.log("the same city and region hospitals are: " + this.SameCityRegion)
      if(this.SameCityRegion.length == 0){
        console.log("no hospitals in same region and same city")
      }

      this.result1 = this.SameCityRegion.split(",");
      console.log(this.result1)
      for(var i = 0; i < this.result1.length-1; i+=7){
        this.name = this.result1[i]
        this.address = this.result1[i+1]
        this.region = this.result1[i+2]
        this.city = this.result1[i+3]
        this.phone = this.result1[i+4]
        this.timeFrom = this.result1[i+5]
        this.timeTo = this.result1[i+6]

        //calling show function to display the same city and region hospitals
        this.showAuthority()
      }
    })
  }


  getSameCityDiffRegion()
  {
    this.http.get('http://localhost:6060/savior/sameCityDiffRegion',{
      responseType:'text',
      observe:'response'
    }).subscribe(response=>{
      this.SameCityDiffRegion = response.body
      console.log("the same city and different region hospitals are: " + this.SameCityDiffRegion)
      if(this.SameCityDiffRegion.length == 0){
        console.log("no hospitals in same city and different region")
      }

    this.result2  = this.SameCityDiffRegion.split(",");
      console.log(this.result2)
      for(var i = 0; i < this.result2.length-1; i+=7){
        this.name = this.result2[i]
        this.address = this.result2[i+1]
        this.region = this.result2[i+2]
        this.city = this.result2[i+3]
        this.phone = this.result2[i+4]
        this.timeFrom = this.result2[i+5]
        this.timeTo = this.result2[i+6]

        //calling show function to display the same city and different region hospitals
        this.showAuthority()
      }
    })
  }

  //will display the region and the city of the far hospital
 

  getDiffCityRegion()
  {
    
    this.http.get('http://localhost:6060/savior/DiffCityRegion',{
      responseType:'text',
      
      observe:'response'
    }).subscribe(response=>{
      this.DiffCityRegion = response.body
      console.log("the different city and region hospitals are: " + this.DiffCityRegion)
      if(this.DiffCityRegion.length == 0){
        console.log("no hospitals in another cities ")
      }

      this.result3 = this.DiffCityRegion.split(",");
      console.log(this.result3)
      for(var i = 0; i < this.result3.length-1; i+=7){
        this.name = this.result3[i]
        this.address = this.result3[i+1]
        this.region = this.result3[i+2]
        this.city = this.result3[i+3]
        this.phone = this.result3[i+4]
        this.timeFrom = this.result3[i+5]
        this.timeTo = this.result3[i+6]

        //calling show function to display the different city and different region hospitals
        this.showAuthority()
      }
    })
    
  }

  chooseAuthority(Name:string , Address:string)
  {
    console.log("choose Authority Calling")
    this.http.get('http://localhost:6060/savior/chooseAuth',{
    responseType:'text',
    params:{
      name: Name,
      address: Address
    },
    observe:'response'
    }).subscribe(response=>{
      this.response = response.body
      console.log(this.response)
      this.router.navigateByUrl('/acceptionTicket') //routing to acceptionTicket
    })
  }

  confirm()
  {
    console.log("confirm calling")
    const authNumber = (<HTMLInputElement>document.getElementById('aNum'))
    this.choosenNumber = authNumber.value
    console.log("user chose authority number: " + this.choosenNumber)

    this.result = this.result1.concat(this.result2, this.result3)
    console.log("the concatenated res: " + this.result)
    var nameInd = (this.choosenNumber-1)*7
    var addressInd = ( (this.choosenNumber-1)*7 ) + 1
    console.log("name index: " + nameInd)
    console.log("address index: " + addressInd)
    this.chooseAuthority(this.result[nameInd], this.result[addressInd])

  }

  



}