# android-ekyc-applicant-sdk-study

eKYC Applicant SDK (Android) の構造を簡易に示したものです。

## Non-Interactive Function

画面のないファンクションの例です。

ファンクションの戻り値:
入力された Parameter が空でない場合は `true`、空の場合は `false` を返します。 

## Interactive Function

画面のあるファンクションの例です。
入力された Parameter が表示されます。

ファンクションの戻り値:
`Result = 1` ボタンをタップした場合 `1`、
`Result = 2` ボタンをタップした場合 `2`、
バックキーで閉じた場合は `0` を返します。
