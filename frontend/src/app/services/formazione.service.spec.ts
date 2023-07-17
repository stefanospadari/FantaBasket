import { TestBed } from '@angular/core/testing';

import { FormazioneService } from './formazione.service';

describe('FormazioneService', () => {
  let service: FormazioneService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FormazioneService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
