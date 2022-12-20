import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import * as internal from 'stream';

@Component({
  selector: 'app-signUp-Individual',
  templateUrl: './signUpI.component.html',
  styleUrls: ['./signUpI.component.css']
})
export class signUpIComponent implements OnInit {

  constructor(private http:HttpClient, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
  }

  Name: any = ''
  ID: any = ''
  Pass: any = ''
  BloodType: any = ''
  Age: any = ''
  Weight: any = ''
  Address: any = ''
  Region: any = ''

  n :any
  asci: any = ''
  hashedPass: any
  response: any = ''

  addName(){
    console.log("d5lt")
    const inputName = (<HTMLInputElement>document.getElementById('name'))
    this.Name = inputName.value
    console.log(this.Name)
  }

  addID(){
    const inputID = (<HTMLInputElement>document.getElementById('id'))
    this.ID = inputID.value
    console.log(this.ID)
  }

  addPassword(){
    const inputPass = (<HTMLInputElement>document.getElementById('password'))
    this.Pass = inputPass.value
    console.log("password before hashing: " + this.Pass)
  }

  addBloodType(){
    const inputType = (<HTMLInputElement>document.getElementById('bType'))
    this.BloodType = inputType.value
    console.log(this.BloodType)
  }

  addAge(){
    const inputAge = (<HTMLInputElement>document.getElementById('age'))
    this.Age = inputAge.value
    console.log(this.Age)
  }

  addWeight(){
    const inputWeight = (<HTMLInputElement>document.getElementById('weight'))
    this.Weight = inputWeight.value
    console.log(this.Weight)
  }

  addAddress(){
    const inputAddress = (<HTMLInputElement>document.getElementById('address'))
    this.Address = inputAddress.value
    console.log(this.Address)
  }

  addRegion(){
    const inputRegion = (<HTMLInputElement>document.getElementById('region'))
    this.Region = inputRegion.value
    console.log(this.Region)
  }

  validation(){
    if(this.Name==''||this.Address==''||this.Age==''||this.BloodType==''||this.Region==''||this.Weight==''){
      alert('Incomplete information')
      return false
    }
    else if(this.ID.length!=6 && this.Pass.length<8){
      alert('INVALID ID and PASSWORD');
      return false
    }
    else if(this.ID.length!=6){
      alert('INVALID ID');
      return false
    }
    else if(this.Pass.length<8){
      alert('INVALID PASSWORD');
      return false
    }
    return true
  }

  showPassword(){
    var x = (<HTMLInputElement>document.getElementById('password'))
    if (x.type === 'password'){
      x.type = "text";
    }else{
      x.type = "password";
    }
  }

     hashPassword(pass: string){
       this.hashedPass = ''
       this.asci = ''
       this.n = pass.length
       for(let i = 0; i < this.n; i++){
           this.asci += pass.charCodeAt(i)
       }
       this.hashedPass = this.asci
       return this.hashedPass;
      }

  SIGNUP_I(ID: any, Password: string, Name: any, Age: any, Weight: any, BloodType: string, Address: string, Region: string){
    console.log("SIGNUP calling")
    this.http.get('http://localhost:6060/savior/signUpI',{ 
      responseType:'text',
      params:{
        id: ID,
        pass: Password,
        name: Name,
        age: Age,
        weight: Weight,
        BT: BloodType,
        adrs: Address,
        region: Region
      },
      observe:'response'
    }).subscribe(response=>{
      this.response = response.body
      console.log(this.response)

      if(this.response=="valid"){
        this.router.navigateByUrl('/welcomeI')
      }
      else if(this.response=="invalid"){
        alert("invalid ID")
        console.log("has not received Done from back")
      }
      else{
        alert("INVALID!")
      }

    })
  }

  INFO_I(){
    this.addName();
    this.addID();
    this.addPassword();
    this.addBloodType();
    this.addAge();
    this.addWeight();
    this.addAddress();
    this.addRegion()
    // this.addCity();
  }

  NEXT(){
    this.INFO_I()
    if(this.validation()){
      console.log('valid');
      this.Pass = this.hashPassword(this.Pass)
      console.log("password after hashing: " + this.Pass)
      this.SIGNUP_I(this.ID, this.Pass, this.Name, this.Age, this.Weight, this.BloodType, this.Address, this.Region)
    }
    else{
      console.log("not valid")
    }
  }

}