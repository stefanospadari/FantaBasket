import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PesiStatisticheComponent } from './pesi-statistiche.component';

describe('PesiStatisticheComponent', () => {
  let component: PesiStatisticheComponent;
  let fixture: ComponentFixture<PesiStatisticheComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PesiStatisticheComponent]
    });
    fixture = TestBed.createComponent(PesiStatisticheComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
