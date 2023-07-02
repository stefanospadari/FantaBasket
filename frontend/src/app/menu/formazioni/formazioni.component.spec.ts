import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormazioniComponent } from './formazioni.component';

describe('FormazioniComponent', () => {
  let component: FormazioniComponent;
  let fixture: ComponentFixture<FormazioniComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FormazioniComponent]
    });
    fixture = TestBed.createComponent(FormazioniComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
