import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StatisticheGiocatoreComponent } from './statistiche-giocatore.component';

describe('StatisticheGiocatoreComponent', () => {
  let component: StatisticheGiocatoreComponent;
  let fixture: ComponentFixture<StatisticheGiocatoreComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [StatisticheGiocatoreComponent]
    });
    fixture = TestBed.createComponent(StatisticheGiocatoreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
