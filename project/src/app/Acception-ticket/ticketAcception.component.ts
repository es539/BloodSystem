import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-Acception-ticket',
  templateUrl: './ticketAcception.component.html',
  styleUrls: ['./ticketAcception.component.css']
})
export class AcceptionTicketComponent implements OnInit {

  constructor(private http:HttpClient, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
  }

  userName: any = this.getUserName()

  name: any = this.getName()
  address: any = this.getAddress()
  region: any = this.getRegion()
  city: any = this.getCity()
  phone: any = this.getPhone()
  dTimeF: any = this.getDTimeF()
  dTimeT: any = this.getDTimeT()
  wTimeF: any = this.getWTimeF()
  wTimeT: any = this.getWTimeT()
  
  response: any 

  getUserName(){
    this.http.get('http://localhost:6060/savior/UserName',{
      responseType:'text',
      params:{
      },
      observe:'response'
    }).subscribe(response=>{
      this.userName = response.body
      console.log("userName from back: " + this.userName)
      if(this.userName != ''){
        console.log("userName received")
      }
      else{
        console.log("did not bring the userName from back")
      }
    })
  }

  getName(){
    this.http.get('http://localhost:6060/savior/chosenAuthName',{
      responseType:'text',
      params:{
      },
      observe:'response'
    }).subscribe(response=>{
      this.name = response.body
      console.log("name from back: " + this.name)
      if(this.name != ''){
        console.log("name received")
      }
      else{
        console.log("did not bring the name from back")
      }
    })
  }

  getAddress(){
    this.http.get('http://localhost:6060/savior/chosenAuthAddress',{
      responseType:'text',
      params:{
      },
      observe:'response'
    }).subscribe(response=>{
      this.address = response.body
      console.log("address from back: " + this.address)
      if(this.address != ''){
        console.log("address received")
      }
      else{
        console.log("did not bring the address from back")
      }
    })
  }

  getRegion(){
    this.http.get('http://localhost:6060/savior/chosenAuthRegion',{
      responseType:'text',
      params:{
      },
      observe:'response'
    }).subscribe(response=>{
      this.region = response.body
      console.log("region from back: " + this.region)
      if(this.address != ''){
        console.log("region received")
      }
      else{
        console.log("did not bring the region from back")
      }
    })
  }

  getCity(){
    this.http.get('http://localhost:6060/savior/chosenAuthCity',{
      responseType:'text',
      params:{
      },
      observe:'response'
    }).subscribe(response=>{
      this.city = response.body
      console.log("city from back: " + this.city)
      if(this.city != ''){
        console.log("city received")
      }
      else{
        console.log("did not bring the city from back")
      }
    })
  }

  getPhone(){
    this.http.get('http://localhost:6060/savior/chosenAuthPhone',{
      responseType:'text',
      params:{
      },
      observe:'response'
    }).subscribe(response=>{
      this.phone = response.body
      console.log("weight from back: " + this.phone)
      if(this.phone != ''){
        console.log("phone received")
      }
      else{
        console.log("did not bring the phone from back")
      }
    })
  }

  getDTimeF(){
    this.http.get('http://localhost:6060/savior/chosenAuthDFrom',{
      responseType:'text',
      params:{
      },
      observe:'response'
    }).subscribe(response=>{
      this.dTimeF = response.body
      console.log("age from back: " + this.dTimeF)
      if(this.dTimeF != ''){
        console.log("dTimeF received")
      }
      else{
        console.log("did not bring the dTimeF from back")
      }
    })
  }

  getDTimeT(){
    this.http.get('http://localhost:6060/savior/chosenAuthDTo',{
      responseType:'text',
      params:{
      },
      observe:'response'
    }).subscribe(response=>{
      this.dTimeT = response.body
      console.log("dTimeT from back: " + this.dTimeT)
      if(this.dTimeF != ''){
        console.log("dTimeF received")
      }
      else{
        console.log("did not bring the dTimeF from back")
      }
    })
  }

  getWTimeF(){
    this.http.get('http://localhost:6060/savior/chosenAuthWStart',{
      responseType:'text',
      params:{
      },
      observe:'response'
    }).subscribe(response=>{
      this.wTimeF = response.body
      console.log("wTimeF from back: " + this.wTimeF)
      if(this.wTimeF != ''){
        console.log("wTimeF received")
      }
      else{
        console.log("did not bring the wTimeF from back")
      }
    })
  }

  getWTimeT(){
    this.http.get('http://localhost:6060/savior/chosenAuthWClose',{
      responseType:'text',
      params:{
      },
      observe:'response'
    }).subscribe(response=>{
      this.wTimeT = response.body
      console.log("wTimeT from back: " + this.wTimeT)
      if(this.wTimeT != ''){
        console.log("wTimeT received")
      }
      else{
        console.log("did not bring the wTimeT from back")
      }
    })
  }

  Book(){
    this.http.get('http://localhost:6060/savior/setWaiting',{
      responseType:'text',
      params:{
      },
      observe:'response'
    }).subscribe(response=>{
      console.log("response from back: " + response.body)
      if(response.body == "Done"){
        alert("Your appointment has booked successfully")
        this.router.navigateByUrl('/thankDonation')
      }
      else{
        alert("something went wrong")
      }
    })
  }

}
