import {ComponentFixture, TestBed} from '@angular/core/testing';

import {FuelTypeDetailsComponent} from './fuel-type-details.component';

describe('FuelTypeDetailsComponent', () => {
  let component: FuelTypeDetailsComponent;
  let fixture: ComponentFixture<FuelTypeDetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FuelTypeDetailsComponent]
    });
    fixture = TestBed.createComponent(FuelTypeDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
