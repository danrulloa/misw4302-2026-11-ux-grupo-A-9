import { Component, input, output, model } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-text-field',
  imports: [FormsModule],
  templateUrl: './text-field.html',
  styleUrl: './text-field.scss',
})
export class TextField {
  label = input.required<string>();
  icon = input.required<string>();
  placeholder = input('');
  fieldType = input<'text' | 'email' | 'password'>('text');
  supportingText = input('');
  errorText = input('');
  fieldName = input.required<string>();
  disabled = input(false);
  value = model('');

  isFocused = false;
}
