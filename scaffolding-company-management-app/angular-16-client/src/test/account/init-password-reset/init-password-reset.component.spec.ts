import {ComponentFixture, TestBed} from '@angular/core/testing';

import {InitPasswordResetComponent} from '../../../app/account/init-password-reset/init-password-reset.component';

describe('InitPasswordResetComponent', () => {
  let component: InitPasswordResetComponent;
  let fixture: ComponentFixture<InitPasswordResetComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [InitPasswordResetComponent]
    });
    fixture = TestBed.createComponent(InitPasswordResetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
