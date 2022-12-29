import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-donation-list',
  templateUrl: './dList.component.html',
  styleUrls: ['./dList.component.css']
})
export class DonationListComponent implements OnInit {

  constructor() { }

  name:any 
  address: any
  phone: any
  timeFrom: any
  timeTo: any

  ngOnInit(): void {

    for(var i=0; i<3; i++){
      document.body.innerHTML += '<div class="containerDon">' 
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
  }


}