import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { appendFile } from 'fs';

@Component({
  selector: 'app-donation',
  templateUrl: './donation.component.html',
  styleUrls: ['./donation.component.css']
})
export class DonationComponent implements OnInit {

  constructor(private http:HttpClient, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
  }

  aids: boolean = false
  virusC: boolean = false
  syphilis: boolean = false
  malaria: boolean = false
  communicableDiseases: boolean = false

  // yes or no
  bDisease: boolean = false
  goodBlood: boolean = false

  //yes or no
  anemia: boolean = false
  noAnemia: boolean = false

  diabetes: boolean = false
  hypert: boolean = false
  cancer: boolean = false
  badHeart: boolean = false
  chronicDiseases: boolean = false

  //yes or no
  pregnant: boolean = false
  notPregnant: boolean = false

  //yes or no
  tatto: boolean = false
  noTatto: boolean = false

  //yes or no
  donated12: boolean = false
  notDonated12: boolean = false

  valid: boolean = true

  hasAids(){
    const checkbox = (<HTMLInputElement>document.getElementById('AIDS'))
    if(checkbox?.checked){
      console.log("has aids")
      this.aids = true
    }
  }

  hasVirusC(){
    const checkbox = (<HTMLInputElement>document.getElementById('virusC'))
    if(checkbox?.checked){
      console.log("has virus C")
      this.virusC = true
    }
  }

  hasSyphilis(){
    const checkbox = (<HTMLInputElement>document.getElementById('syphilis'))
    if(checkbox?.checked){
      console.log("has syphilis")
      this.syphilis = true
    }
  }

  hasMalaria(){
    const checkbox = (<HTMLInputElement>document.getElementById('malaria'))
    if(checkbox?.checked){
      console.log("has malaria")
      this.malaria = true
    }
  }

  hasCommunicableDiseases(){
    this.hasAids()
    this.hasVirusC()
    this.hasSyphilis()
    this.hasMalaria()
    if(this.aids || this.virusC || this.syphilis || this.malaria){
      console.log("has communicableDiseases")
      this.communicableDiseases = true
    }
  }

  hasBloodProblem(){
    const radio = (<HTMLInputElement>document.getElementById('bloodProblem'))
    if(radio?.checked){
      console.log("has blood Problem")
      this.bDisease = true
    }
  }
  hasNOTBloodProblem(){
    const radio = (<HTMLInputElement>document.getElementById('goodBlood'))
    if(radio?.checked){
      console.log("has NOT blood Problem")
      this.goodBlood = true
    }
  }

  hasAnemia(){
    const radio = (<HTMLInputElement>document.getElementById('anemia'))
    if(radio?.checked){
      console.log("has anemia")
      this.anemia = true
    }
  }

  hasNOTAnemia(){
    const radio = (<HTMLInputElement>document.getElementById('noAnemia'))
    if(radio?.checked){
      console.log("has NOT anemia")
      this.noAnemia = true
    }
  }

  hasDiabetes(){
    const checkbox = (<HTMLInputElement>document.getElementById('diabetes'))
    if(checkbox?.checked){
      console.log("has diabetes")
      this.diabetes = true
    }
  }

  hasHypert(){
    const checkbox = (<HTMLInputElement>document.getElementById('hypert'))
    if(checkbox?.checked){
      console.log("has hypert")
      this.hypert = true
    }
  }

  hasCancer(){
    const checkbox = (<HTMLInputElement>document.getElementById('cancer'))
    if(checkbox?.checked){
      console.log("has cancer")
      this.cancer = true
    }
  }

  hasBadHeart(){
    const checkbox = (<HTMLInputElement>document.getElementById('badheart'))
    if(checkbox?.checked){
      console.log("has bad heart")
      this.badHeart = true
    }
  }

  hasChronicDiseases(){
    this.hasDiabetes()
    this.hasHypert()
    this.hasCancer()
    this.hasBadHeart()
    if(this.diabetes || this.hypert || this.cancer || this.badHeart){
      console.log("has chronic Diseases")
      this.chronicDiseases = true
    }
  }

  isPregnant(){
    const checkbox = (<HTMLInputElement>document.getElementById('pregnant'))
    if(checkbox?.checked){
      console.log("is pregnant")
      this.pregnant = true
    }
  }

  isNOTPregnant(){
    const checkbox = (<HTMLInputElement>document.getElementById('pregnantFalse'))
    if(checkbox?.checked){
      console.log("is NOT pregnant")
      this.notPregnant = true
    }
  }

  hasTatto(){
    const checkbox = (<HTMLInputElement>document.getElementById('tatto'))
    if(checkbox?.checked){
      console.log("has tatto")
      this.tatto = true
    }
  }

  hasNOTatto(){
    const checkbox = (<HTMLInputElement>document.getElementById('noTatto'))
    if(checkbox?.checked){
      console.log("has NOT tatto")
      this.noTatto = true
    }
  }

  hasDonaed12(){
    const checkbox = (<HTMLInputElement>document.getElementById('pastDonate'))
    if(checkbox?.checked){
      console.log("has donated 12")
      this.donated12 = true
    }
  }

  hasNOTDonaed12(){
    const checkbox = (<HTMLInputElement>document.getElementById('firstDonate'))
    if(checkbox?.checked){
      console.log("has NOT donated 12")
      this.notDonated12 = true
    }
  }

  INFO(){
    this.hasCommunicableDiseases()
    this.hasBloodProblem()
    this.hasNOTBloodProblem()
    this.hasAnemia()
    this.hasNOTAnemia()
    this.hasChronicDiseases()
    this.isPregnant()
    this.isNOTPregnant()
    this.hasTatto()
    this.hasNOTatto()
    this.hasDonaed12()
    this.hasNOTDonaed12()
  }

  isValidDonator(){
    this.INFO()
    if( (!this.bDisease&&!this.goodBlood)
    || (!this.anemia&&!this.noAnemia) 
    || (!this.pregnant&&!this.notPregnant) 
    || (!this.donated12&&!this.notDonated12)){
      alert('please, choose either YES or NO')
    }
    else if(this.communicableDiseases || this.bDisease || this.anemia || this.chronicDiseases || this.pregnant || this.tatto || this.donated12){
      console.log("invalid donator")
      this.valid = false
      this.router.navigateByUrl("/invalidDonate")
    }
    else{
      console.log("valid donator")
      this.valid = true
      this.router.navigateByUrl("/donateList")
    }
  }

}