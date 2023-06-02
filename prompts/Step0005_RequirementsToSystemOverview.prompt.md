
# Requirements

投資信託の取引システムを作成するための機能要件の詳細なまとめを以下に示します：
販売者側のシステムにおける機能要件を以下にまとめます：

1. プロダクト管理:
   - 販売する投資信託の情報を管理できる
   - 投資信託の詳細情報（運用方針、パフォーマンス履歴、経費率など）を登録できる
   - 投資信託の価格や手数料などの情報を更新できる
   - 新しい投資信託を追加できる

2. 注文管理:
   - ユーザーの投資信託の購入・売却注文を受け付け、処理できる
   - 注文の成立状況を追跡できる
   - 注文履歴を管理できる

3. 顧客管理:
   - ユーザーのアカウント情報を管理できる
   - ユーザーの投資目標やリスク許容度などの情報を保存できる
   - ユーザーのポートフォリオを表示できる
   - ユーザーに対して通知やアラートを送信できる

4. リサーチ情報:
   - 投資信託に関する情報やリサーチレポートを提供できる
   - ユーザーに対して投資アドバイスを提供できる

5. 報告書生成:
   - ユーザーの投資信託の評価額や収益率を計算・生成できる
   - ユーザーに対して定期的な報告書を提供できる
   - 法的な要件に基づいた報告書の生成をサポートできる

6. セキュリティと認証:
   - システムへのアクセスを制限できるセキュリティ機能を提供できる
   - 販売者側のスタッフや代理店のアカウントを管理できる
   - 適切な認証手段（ユーザー名とパスワード、二要素認証など）を実装できる

7. 報酬計算:
   - 販売者への報酬や手数料の計算を行える
   - 販売者への報酬支払いの履歴を管理できる

以上の機能要件は、販売者側のシステムがスムーズに運営され、投資信託の販売と管理が効率的に行われるために必要です。



# prompt

Please understand the requirements well and express the system overview concisely.
{"name": "${Please give an appropriate name that reflects the reality of the system.}","nickname":"${Please give a familiar and easy-to-call nickname to the user.}", "overview": "${System Overview}", "rules": ["${Business rules and constraints}"]}
