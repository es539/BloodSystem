import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import * as internal from 'stream';

@Component({
  selector: 'app-Edit-Authority',
  templateUrl: './EditA.component.html',
  styleUrls: ['./EditA.component.css']
})
export class EditAComponent implements OnInit {

  constructor(private http:HttpClient, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
  }

  // info can be edited
  Name: any = ''
  Email: any = ''
  Phone: any = ''
  Pass: any = ''
  Address: any = ''
  City: any = ''
  Region: any = ''
  WFrom: any = ''
  WTo: any = ''
  DAFrom: any = ''
  DATo: any = ''

  // blood types needed and exist
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

  nameAuth(){
    const authName = (<HTMLInputElement>document.getElementById('name'))
    this.Name = authName.value
    console.log(this.Name)
    }

    emailAuth(){
      const authEmail = (<HTMLInputElement>document.getElementById('email'))
      this.Email = authEmail.value
      console.log(this.Email)
    }

    phoneAuth(){
      const authPhone = (<HTMLInputElement>document.getElementById('phone'))
      this.Phone = authPhone.value
      console.log(this.Phone)
    }

    passwordAuth(){
      const authPassword = (<HTMLInputElement>document.getElementById('password'))
      this.Pass = authPassword.value
      console.log("password after hashing" + this.Pass)
    }

    addressAuth(){
      const authAddress = (<HTMLInputElement>document.getElementById('address'))
      this.Address = authAddress.value
      console.log(this.Address)
    }

    regionAuth(){
      const authRegion = (<HTMLInputElement>document.getElementById('region'))
      this.Region = authRegion.value
      console.log(this.Region)
    }

    startWorkAuth(){
      const authStartW = (<HTMLInputElement>document.getElementById('wHourf'))
      this.WFrom = authStartW.value
      console.log(this.WFrom)
    }

    endWorkAuth(){
      const authEndW = (<HTMLInputElement>document.getElementById('wHourt'))
      this.WTo = authEndW.value
      console.log(this.WTo)
    }

    startDonAuth(){
      const authStartD = (<HTMLInputElement>document.getElementById('dTimeF'))
      this.DAFrom = authStartD.value
      console.log(this.DAFrom)
    }
  
    endDonAuth(){
      const authEndD = (<HTMLInputElement>document.getElementById('dTimeT'))
      this.DATo = authEndD.value
      console.log(this.DATo)
    }

    existBagsAuth(){
      const EAplus = (<HTMLInputElement>document.getElementById('APEBags'))
      this.ExistAplus = EAplus.value
      console.log(this.ExistAplus)

      const EAminus = (<HTMLInputElement>document.getElementById('ANEBags'))
      this.ExistAminus = EAminus.value
      console.log(this.ExistAminus)

      const EBplus = (<HTMLInputElement>document.getElementById('BPEBags'))
      this.ExistBplus = EBplus.value
      console.log(this.ExistBplus)
  
      const EBminus = (<HTMLInputElement>document.getElementById('BNEBags'))
      this.ExistBminus = EBminus.value
      console.log(this.ExistBminus)
  
      const EABplus = (<HTMLInputElement>document.getElementById('ABPEBags'))
      this.ExistABplus = EABplus.value
      console.log(this.ExistABplus)

      const EABminus = (<HTMLInputElement>document.getElementById('ABNEBags'))
      this.ExistABminus = EABminus.value
      console.log(this.ExistABminus)
  
      const EOplus = (<HTMLInputElement>document.getElementById('OPEBags'))
      this.ExistOplus = EOplus.value
      console.log(this.ExistOplus)
  
      const EOminus = (<HTMLInputElement>document.getElementById('ONEBags'))
      this.ExistOminus = EOminus.value
      console.log(this.ExistOminus)
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
      if(this.Name==''||this.Address==''||this.Region==''||this.Email==''||this.Pass==''
      || this.WFrom=='' || this.WTo=='' || this.DAFrom=='' || this.DATo=='' || this.Phone==''
      || this.ExistAplus=='' || this.ExistAminus=='' || this.ExistABplus=='' || this.ExistABminus=='' 
      || this.ExistBplus=='' || this.ExistBminus=='' || this.ExistOplus=='' || this.ExistOminus==''){
        alert('Incomplete information')
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

     modifyAccAuth(Email: string, Phone: string, Password: string, Name: string, Address: string, Region: string,
      Start: string, End: string, DAFrom: string, DATo: string, 
      EAp: any, EAm: any, EBp: any, EBm: any,
      EABp: any, EABm: any, EOp: any, EOm: any){
      console.log("modifyAccCalling")
      this.http.get('http://localhost:6060/savior/editAccA',{ 
        responseType:'text',
        params:{
          email: Email,
          phone: Phone,
          pass: Password,
          name: Name,
          adrs: Address,
          region: Region,
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
        console.log("the response from modifyAccAuth: " + this.response)
  
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
    this.nameAuth()
    this.emailAuth()
    this.phoneAuth()
    this.passwordAuth()
    this.addressAuth()
    this.regionAuth()
    this.startWorkAuth()
    this.endWorkAuth()
    this.startDonAuth()
    this.endDonAuth()
    this.existBagsAuth()
  }

  NEXT(){
    this.INFO()
    if(this.validation()){
      console.log('valid');
      this.Pass = this.hashPassword(this.Pass)
      console.log("password after hashing: " + this.Pass)
      this.modifyAccAuth(this.Email, this.Phone, this.Pass, this.Name, this.Address, this.Region, this.WFrom, this.WTo, this.DAFrom, this.DATo
        ,this.ExistAplus, this.ExistAminus, this.ExistBplus, this.ExistBminus
        ,this.ExistABplus, this.ExistABminus, this.ExistOplus, this.ExistOminus)
        this.hashedPass = ''
    }
    else{
      console.log("not valid")
      alert("INVALID!")
    }
  }
}