import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { PageBackground } from '../../shared/components/page-background/page-background';
import { ProfileCard } from '../../shared/components/profile-card/profile-card';
import { AddFamilyCard } from '../../shared/components/add-family-card/add-family-card';
import { Divider } from '../../shared/components/divider/divider';

@Component({
  selector: 'app-seleccion-perfil-familiar',
  imports: [PageBackground, ProfileCard, AddFamilyCard, Divider],
  templateUrl: './seleccion-perfil-familiar.html',
  styleUrl: './seleccion-perfil-familiar.scss',
})
export class SeleccionPerfilFamiliar {
  constructor(private router: Router) {}

  onEnterMainProfile(): void {
    console.log('Entering main profile');
  }

  onEnterFamilyProfile(): void {
    console.log('Entering family profile');
  }

  onAddFamily(): void {
    this.router.navigate(['/crear-perfil']);
  }
}
