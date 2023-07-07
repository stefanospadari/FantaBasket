import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TitolareComponent } from './titolare.component';

describe('TitolareComponent', () => {
  let component: TitolareComponent;
  let fixture: ComponentFixture<TitolareComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TitolareComponent]
    });
    fixture = TestBed.createComponent(TitolareComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
