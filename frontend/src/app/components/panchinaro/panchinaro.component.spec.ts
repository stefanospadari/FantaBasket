import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PanchinaroComponent } from './panchinaro.component';

describe('PanchinaroComponent', () => {
  let component: PanchinaroComponent;
  let fixture: ComponentFixture<PanchinaroComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PanchinaroComponent]
    });
    fixture = TestBed.createComponent(PanchinaroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
