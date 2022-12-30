import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DonationTicketComponent } from './ticketDonation.component';

describe('DonationTicketComponent', () => {
  let component: DonationTicketComponent;
  let fixture: ComponentFixture<DonationTicketComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DonationTicketComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DonationTicketComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
