import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModificaSquadreComponent } from './modifica-squadre.component';

describe('ModificaSquadreComponent', () => {
  let component: ModificaSquadreComponent;
  let fixture: ComponentFixture<ModificaSquadreComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ModificaSquadreComponent]
    });
    fixture = TestBed.createComponent(ModificaSquadreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
