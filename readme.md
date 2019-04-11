# Codeclan
## Week 13 Day 3
### JAVA DB Interaction
### Advanced Queries, Hibernate Data Queries and Custom Queries

#### Instructions

You are given the task of creating db queries in Java for a whisky tracking app. Using your knowledge of creating custom queries using Hibernate. See Instructions.md for full breif.

####  Notes

* Imagine hibernate isn't there, this is just creating a series of whereclauses.

* You can chain queries/restrictions together by doing .add(restiction1).add(restriction2)

* May be worth investigating further how to translate your understanding from SQL to hibernate functionality 

#### Order of Approach

* Start with your result first - what si it you want to return?

* Move to the repo of return object, you want the repo to *implement* the exact method defined in objectRepoImpl(necessary Spring term) while inheriting from objectRepoCustom(again) which allows you to inherit all Spring CRUD functionality while adding in custom queries

* Create your test first, check the seed data and confirm results - use indirect testing if necessary.

* Note cheatsheet for errors

#### Files

