import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AcceptionTicketComponent } from './ticketAcception.component';

describe('AcceptionTicketComponent', () => {
  let component: AcceptionTicketComponent;
  let fixture: ComponentFixture<AcceptionTicketComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AcceptionTicketComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AcceptionTicketComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
