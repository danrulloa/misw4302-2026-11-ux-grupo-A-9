import { Component, output, signal } from '@angular/core';

@Component({
  selector: 'app-date-picker',
  templateUrl: './date-picker.html',
  styleUrl: './date-picker.scss',
})
export class DatePicker {
  selected = output<string>();
  cancelled = output<void>();

  selectedDay = signal(17);
  today = 5;

  days = [
    [0, 0, 1, 2, 3, 4, 5],
    [6, 7, 8, 9, 10, 11, 12],
    [13, 14, 15, 16, 17, 18, 19],
    [20, 21, 22, 23, 24, 25, 26],
    [27, 28, 29, 30, 31, 0, 0],
  ];

  weekDays = ['D', 'L', 'M', 'M', 'J', 'V', 'S'];

  selectDay(day: number): void {
    if (day > 0) this.selectedDay.set(day);
  }

  onOk(): void {
    this.selected.emit(`17/08/2025`);
  }

  onCancel(): void {
    this.cancelled.emit();
  }
}
