import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { PageBackground } from '../../shared/components/page-background/page-background';
import { ProfileCard } from '../../shared/components/profile-card/profile-card';
import { AddFamilyCard } from '../../shared/components/add-family-card/add-family-card';
import { Divider } from '../../shared/components/divider/divider';
import { ConfirmDialog } from '../../shared/components/confirm-dialog/confirm-dialog';

@Component({
  selector: 'app-seleccion-perfil',
  imports: [PageBackground, ProfileCard, AddFamilyCard, Divider, ConfirmDialog],
  templateUrl: './seleccion-perfil.html',
  styleUrl: './seleccion-perfil.scss',
})
export class SeleccionPerfil {
  showConfirmDialog = false;

  constructor(private router: Router) {}

  onEnterProfile(): void {
    console.log('Entering user profile');
  }

  onAddFamily(): void {
    this.showConfirmDialog = true;
  }

  onConfirmAdd(): void {
    this.showConfirmDialog = false;
    this.router.navigate(['/crear-perfil']);
  }

  onCancelAdd(): void {
    this.showConfirmDialog = false;
  }
}
