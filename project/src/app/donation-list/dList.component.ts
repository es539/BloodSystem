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
  phone: any
  timeFrom: any
  timeTo: any

  region: any
  city: any

  sameRegionAuth: any
  sameCityAuth: any
  otherCitiesAuth: any

  // response: any

  ngOnInit(): void {
    this.getSameRegionAuth()
    this.getSameCityAuth()
    this.getOtherCitiesAuth()    
  }

   showAuthRegion(){
      document.body.innerHTML += '<div class="containerDon">' 
      + '<div>Authorities in your region: </div>'
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
              +'<button class="btn btn-danger col-2 m-1">Choose</button>'

            + '</div>' 
          + '</div>' 
        + '</div>'
      +'</div>'
   }

   showAuthCity(){
    document.body.innerHTML += '<div class="containerDon">' 
    + '<div>Authorities in other regions in your city: </div>'
    + '<div class="proContent" style="max-width: 700px;">' 
      + '<div class="scroll-container">' 
        + '<div class="card p-3 border border-danger m-3">' 
          + '<div class="row">'

            + '<p class="col-12" id="hos-name">'+ this.name +'</p>' 
            + '<p class="col-6" id="hos-addr">' + this.address + '</p>'  
            + '<p class="col-6" id="hos-addr">' + this.region + '</p>' 
            +'<br>'
            +'<p class="col-12" id="hos-numb">' + this.phone + '</p>'
            +'<p class="col-12" for="">Donation time:</p>'
            +'<p class="col-6">From:' + this.timeFrom + '</p>'
            +'<P class="col-4">To:' + this.timeTo + '</P>'
            +'<button class="btn btn-danger col-2 m-1">Choose</button>'

          + '</div>' 
        + '</div>' 
      + '</div>'
    +'</div>'
 }

 showAuthFar(){
  document.body.innerHTML += '<div class="containerDon">' 
  + '<div>Authorities in other cities: </div>'
  + '<div class="proContent" style="max-width: 700px;">' 
    + '<div class="scroll-container">' 
      + '<div class="card p-3 border border-danger m-3">' 
        + '<div class="row">'

          + '<p class="col-12" id="hos-name">'+ this.name +'</p>' 
          + '<p class="col-6" id="hos-addr">' + this.address + '</p>'  
          + '<p class="col-6" id="hos-addr">' + this.region + '</p>' 
          + '<p class="col-6" id="hos-addr">' + this.city + '</p>' 
          +'<br>'
          +'<p class="col-12" id="hos-numb">' + this.phone + '</p>'
          +'<p class="col-12" for="">Donation time:</p>'
          +'<p class="col-6">From:' + this.timeFrom + '</p>'
          +'<P class="col-4">To:' + this.timeTo + '</P>'
          +'<button class="btn btn-danger col-2 m-1">Choose</button>'

        + '</div>' 
      + '</div>' 
    + '</div>'
  +'</div>'
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

      var res = this.sameRegionAuth.split(",");
      console.log(res)
      for(var i = 0; i < res.length-1; i+=5){
        this.name = res[i]
        this.address = res[i+1]
        this.phone = res[i+2]
        this.timeFrom = res[i+3]
        this.timeTo = res[i+4]

        //html
        this.showAuthRegion()
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

      var res = this.sameCityAuth.split(",");
      console.log(res)
      for(var i = 0; i < res.length-1; i+=6){
        this.name = res[i]
        this.address = res[i+1]
        this.region = res[i+2]
        this.phone = res[i+3]
        this.timeFrom = res[i+4]
        this.timeTo = res[i+5]

        //html
        this.showAuthCity()
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

      var res = this.otherCitiesAuth.split(",");
      console.log(res)
      for(var i = 0; i < res.length-1; i+=7){
        this.name = res[i]
        this.address = res[i+1]
        this.region = res[i+2]
        this.city = res[i+3]
        this.phone = res[i+4]
        this.timeFrom = res[i+5]
        this.timeTo = res[i+6]

        //html
        this.showAuthFar()
      }
    })
  }


}