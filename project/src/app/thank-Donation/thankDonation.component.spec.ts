import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ThankDonationComponent } from './thankDonation.component';

describe('ThankDonationComponent', () => {
  let component: ThankDonationComponent;
  let fixture: ComponentFixture<ThankDonationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ThankDonationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ThankDonationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
