# @All            # Label for all scenarios
# @{Feature}      # key word relevant of the feature

@All
@Google
@Search
@SearchByText
Feature: Search by text
  As an google user
  I want to enter keywords into a search bar
  So that I can to receive relevant results & to find information quickly and efficiently

  # @HP            # Test Type [Happy Path | Alter Path]
  # @Regression    # Apply for regression
  # @Smoke         # Apply for smoke test
  # @ID-####       # ID test case, on tool test management
  # @Actual        # Scenario in automation progress actually

  @This
    @HP
    @ID-001 # [E2E-HP] Search by text, successfully
  Scenario Outline: [E2E-HP] Search by text, successfully
  [E2E-HP] Search by text, successfully
      # R/ ¿Where is the actor? --> location / context
      # R/ ¿What did the actor finish doing? --> previously, in past time
    Given that "user" is on the google search
      # R/ ¿What is the actor doing? --> in present time, behaviour SUT
    When search by text "<text_search>", successfully
      # R/ ¿What is expected? --> in future time, validation / verification
      # R/ ¿What is the consequence of your actions? --> in future time, what will happen
    Then should be presented the information related for "<text_search>"


    Examples:
      | text_search      |
      | Cucumber testing |

