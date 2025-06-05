---
title: Student Support Code for 'Cycle Chronicles' Task
---

<!-- pandoc -s -f markdown -t markdown --columns=94 --reference-links=true README.md -->

## About

This represents the student support code for the [Cycle Chronicles task].

## License

This [work] by [Carsten Gips] and [contributors] is licensed under [MIT].

  [Cycle Chronicles task]: https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/tree/master/homework
  [work]: https://github.com/Programmiermethoden-CampusMinden/prog2_ybel_cyclechronicles
  [Carsten Gips]: https://github.com/cagix
  [contributors]: https://github.com/Programmiermethoden-CampusMinden/prog2_ybel_cyclechronicles/graphs/contributors
  [MIT]: LICENSE.md



# ÄK
1: Type=!(Gravel,EBike)
2: CustomerOrderCount==0
3: PendingOrders<=4

# Grenzwerte
1: Type=Gravel,EBike (This Enum does not have a sensible range)
2: CustomerOrderCount=1 (Zero is the only valid option, negative is impossible)
3: PendingOrders: 4 should still be good, 5 should fail | Indirectly includes: OtherCustomerOrderCount>=0

Testfall:
OK: Type:Race,Single_SPEED,FIXIE, orderCount=0, pendingOrders=0
FailType: Type:Gravel,EBike, OrderCount=0, PendingOrders=0
FailOrderCount: Type:Race, OrderCount=1, pendingOrders=0
FailPendingOrders: Type:Race, OrderCount=0, pendingOrders=5
OKPendingOrders: Type:Race, OrderCount=0, pendingOrders=4
