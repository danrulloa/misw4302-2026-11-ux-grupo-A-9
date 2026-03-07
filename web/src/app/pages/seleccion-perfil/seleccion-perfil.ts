import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';
import { PageBackground } from '../../shared/components/page-background/page-background';
import { ProfileCard } from '../../shared/components/profile-card/profile-card';
import { AddFamilyCard } from '../../shared/components/add-family-card/add-family-card';
import { Divider } from '../../shared/components/divider/divider';
import { UserService } from '../../shared/services/user.service';

@Component({
  selector: 'app-seleccion-perfil',
  imports: [PageBackground, ProfileCard, AddFamilyCard, Divider],
  templateUrl: './seleccion-perfil.html',
  styleUrl: './seleccion-perfil.scss',
})
export class SeleccionPerfil {
  userService = inject(UserService);

  constructor(private router: Router) {}

  onEnterProfile(): void {
    this.router.navigate(['/home-alarmas']);
  }

  onAddFamily(): void {
    this.router.navigate(['/crear-perfil']);
  }
}
