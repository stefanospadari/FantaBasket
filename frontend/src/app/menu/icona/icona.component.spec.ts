import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IconaComponent } from './icona.component';

describe('IconaComponent', () => {
  let component: IconaComponent;
  let fixture: ComponentFixture<IconaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [IconaComponent]
    });
    fixture = TestBed.createComponent(IconaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
