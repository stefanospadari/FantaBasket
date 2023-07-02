import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SvincolatiComponent } from './svincolati.component';

describe('SvincolatiComponent', () => {
  let component: SvincolatiComponent;
  let fixture: ComponentFixture<SvincolatiComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SvincolatiComponent]
    });
    fixture = TestBed.createComponent(SvincolatiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
