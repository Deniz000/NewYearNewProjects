uzaylı_rengi = input("Uzaylının rengini girin (kırmızı, yeşil, sarı): ")

if uzaylı_rengi == "yeşil":
    print("Tebrikler, yeşil uzaylıya ateş ettiğiniz için 5 puan kazandınız.")
elif uzaylı_rengi == "sarı":
    print("Tebrikler, sarı uzaylıya ateş ettiğiniz için 10 puan kazandınız.")
elif uzaylı_rengi == "kırmızı":
    print("Tebrikler, kırmızı uzaylıya ateş ettiğiniz için 15 puan kazandınız.")
else:
    print("Geçersiz renk! Lütfen kırmızı, yeşil veya sarı renklerinden birini girin.")