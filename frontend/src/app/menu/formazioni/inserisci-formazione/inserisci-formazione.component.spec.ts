import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InserisciFormazioneComponent } from './inserisci-formazione.component';

describe('InserisciFormazioneComponent', () => {
  let component: InserisciFormazioneComponent;
  let fixture: ComponentFixture<InserisciFormazioneComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [InserisciFormazioneComponent]
    });
    fixture = TestBed.createComponent(InserisciFormazioneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
