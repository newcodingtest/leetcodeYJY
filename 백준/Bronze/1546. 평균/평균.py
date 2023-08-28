subject = int(input())
score = list(map(int, input().split()))
new_score = []
new_score_gross = 0

for i in score:
    new_score.append(i / max(score) * 100)

for j in range(subject):
    new_score_gross += new_score[j]

print(round(new_score_gross / subject,6))