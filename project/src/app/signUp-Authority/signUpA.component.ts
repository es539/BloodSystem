import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import * as internal from 'stream';

@Component({
  selector: 'app-signUp-Authority',
  templateUrl: './signUpA.component.html',
  styleUrls: ['./signUpA.component.css']
})
export class signUpAComponent implements OnInit {

  constructor(private http:HttpClient, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
  }

  Name: any = ''
  Email: any = ''
  Phone: any = ''
  Pass: any = ''
  Address: any = ''
  City: any = ''
  Region: any = ''
  Tax: any = ''
  WFrom: any = ''
  WTo: any = ''
  DAFrom: any = ''
  DATo: any = ''

  ExistAplus: any = ''
  ExistAminus: any = ''
  ExistBplus: any = ''
  ExistBminus: any = ''
  ExistABplus: any = ''
  ExistABminus: any = ''
  ExistOplus: any = ''
  ExistOminus: any = ''

  info: any

  n :any
  asci: any = ''
  hashedPass: any = ''
  response: any = ''

  addName(){
    const inputName = (<HTMLInputElement>document.getElementById('name'))
    this.Name = inputName.value
    console.log(this.Name)
  }

  addEmail(){
    const inputEmail = (<HTMLInputElement>document.getElementById('email'))
    this.Email = inputEmail.value
    console.log(this.Email)
  }

  addPhone(){
    const inputPhone = (<HTMLInputElement>document.getElementById('phone'))
    this.Phone = inputPhone.value
    console.log(this.Phone)
  }

  addPassword(){
    const inputPass = (<HTMLInputElement>document.getElementById('password'))
    this.Pass = inputPass.value
    console.log("password after hashing" + this.Pass)
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

  addTax(){
    const inputTax = (<HTMLInputElement>document.getElementById('tax'))
    this.Tax = inputTax.value
    console.log(this.Tax)
  }
  
  addWFrom(){
    const inputWFrom = (<HTMLInputElement>document.getElementById('wHourf'))
    this.WFrom = inputWFrom.value
    console.log(this.WFrom)
  }

  addWTo(){
    const inputWTo = (<HTMLInputElement>document.getElementById('wHourt'))
    this.WTo = inputWTo.value
    console.log(this.WTo)
  }

  addDAFrom(){
    const inputDAFrom = (<HTMLInputElement>document.getElementById('dTimeF'))
    this.DAFrom = inputDAFrom.value
    console.log(this.DAFrom)
  }

  addDATo(){
    const inputDATo = (<HTMLInputElement>document.getElementById('dTimeT'))
    this.DATo = inputDATo.value
    console.log(this.DATo)
  }

  addExistBags1_1(){
    const EAplus = (<HTMLInputElement>document.getElementById('APEBags'))
    this.ExistAplus = EAplus.value

    const EAminus = (<HTMLInputElement>document.getElementById('ANEBags'))
    this.ExistAminus = EAminus.value

    const EBplus = (<HTMLInputElement>document.getElementById('BPEBags'))
    this.ExistBplus = EBplus.value

    const EBminus = (<HTMLInputElement>document.getElementById('BNEBags'))
    this.ExistBminus = EBminus.value

    const EABplus = (<HTMLInputElement>document.getElementById('ABPEBags'))
    this.ExistABplus = EABplus.value

    const EABminus = (<HTMLInputElement>document.getElementById('ABNEBags'))
    this.ExistABminus = EABminus.value

    const EOplus = (<HTMLInputElement>document.getElementById('OPEBags'))
    this.ExistOplus = EOplus.value

    const EOminus = (<HTMLInputElement>document.getElementById('ONEBags'))
    this.ExistOminus = EOminus.value
  }

  addExistBags(): Map<string, string>{
    var EBags = new Map<string, string>();
    EBags.set("A+", this.ExistAplus)
    EBags.set("A-", this.ExistAminus)
    EBags.set("B+", this.ExistBplus)
    EBags.set("B-", this.ExistBminus)
    EBags.set("AB+", this.ExistABplus)
    EBags.set("AB-", this.ExistABminus)
    EBags.set("O+", this.ExistOplus)
    EBags.set("O-", this.ExistOminus)

    return EBags
  }

  validation(){
    let i = this.Email.length
    if(this.Name==''||this.Address==''||this.Region==''||this.Email==''||this.Pass==''||this.Tax==''
    || this.WFrom=='' || this.WTo=='' || this.DAFrom=='' || this.DATo=='' || this.Phone==''
    || this.ExistAplus=='' || this.ExistAminus=='' || this.ExistABplus=='' || this.ExistABminus=='' 
    || this.ExistBplus=='' || this.ExistBminus=='' || this.ExistOplus=='' || this.ExistOminus==''){
      alert('Incomplete information')
      return false
    }
    else if(this.Tax.length!=9 && this.Pass.length<8){
      alert('INVALID tax number and PASSWORD');
      return false
    }
    else if(this.Tax.length!=9){
      alert('INVALID tax number');
      return false
    }
    else if(this.Pass.length<8){
      alert('INVALID PASSWORD, its length is < 8');
      return false
    }
    else if(this.Email[i-1]!='m' || this.Email[i-2]!='o' || this.Email[i-3]!='c' || this.Email[i-4]!='.' || this.Email[i-5]!='l' || this.Email[i-6]!='i' || this.Email[i-7]!='a' || this.Email[i-8]!='m' || this.Email[i-9]!='g' || this.Email[i-10]!='@'){
      alert('INVALID GMAIL');
      return false
    }
    else if(this.Phone.length!=11){
      alert('INVALID Phone number')
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
  

  SIGNUP(Email: string, Phone: string, Password: string, Name: string, Address: string, Region: string, Tax: string, 
    Start: string, End: string, DAFrom: string, DATo: string, 
    EAp: any, EAm: any, EBp: any, EBm: any, 
    EABp: any, EABm: any, EOp: any, EOm: any,){
    console.log("SIGNUP calling")
    this.http.get('http://localhost:6060/savior/signUpA',{ 
      responseType:'text',
      params:{
        email: Email,
        phone: Phone,
        pass: Password,
        name: Name,
        adrs: Address,
        region: Region,
        tax: Tax,
        start: Start,
        end: End,
        donationF: DAFrom,
        donationT: DATo,
        EAplus: EAp,
        EAminus: EAm,
        EBplus: EBp,
        EBminus: EBm,
        EABplus: EABp,
        EABminus: EABm,
        EOplus: EOp,
        EOminus: EOm,
      },
      observe:'response'
    }).subscribe(response=>{
      this.response = response.body
      console.log(this.response)

      if(this.response=="valid"){
        this.router.navigateByUrl('/welcomeA')
      }
      else if(this.response=="invalid"){
        console.log("has not received Done from back")
      }
      else{
        alert("INVALID!")
      }

    })
  }

  INFO(){
    this.addName();
    this.addEmail();
    this.addPhone()
    this.addPassword();
    this.addAddress();
    this.addRegion()
    this.addTax()
    this.addWFrom();
    this.addWTo();
    this.addDAFrom();
    this.addDATo();
    this.addExistBags1_1()
  }

  NEXT(){
    this.INFO()
    if(this.validation()){
      console.log('valid');
      this.Pass = this.hashPassword(this.Pass)
      console.log("password after hashing: " + this.Pass)
      this.SIGNUP(this.Email, this.Phone, this.Pass, this.Name, this.Address, this.Region, this.Tax, this.WFrom, this.WTo, this.DAFrom, this.DATo
        ,this.ExistAplus, this.ExistAminus, this.ExistBplus, this.ExistBminus
        ,this.ExistABplus, this.ExistABminus, this.ExistOplus, this.ExistOminus)
    }
    else{
      console.log("not valid")
      // alert("INVALID!")
    }
  }

}